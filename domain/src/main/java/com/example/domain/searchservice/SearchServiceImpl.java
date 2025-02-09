package com.example.domain.searchservice;

import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.common.model.response.LogResponse;
import com.example.domain.document.Place;
import com.example.domain.document.PlaceLog;
import com.example.domain.document.dao.CategoryDAO;
import com.example.domain.document.dao.SearchDAO;
import com.example.domain.mapper.FoodMapper;
import com.example.domain.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl  implements  SearchService{

    private  final CategoryDAO categoryDAO;

    private  final SearchDAO searchDAO;
    private final ConcurrentLinkedQueue<PlaceLog> logQueue = new ConcurrentLinkedQueue<>();

    private static final int BATCH_SIZE = 20;  //

    private  final FoodMapper foodMapper;
    private  final PlaceMapper touristMapper;


    @Override
    public List<PlaceRequest> getAreaPlaceList(String area,int num)  {
        return touristMapper.Tourist_To_DTO(categoryDAO.findAreaPlace(area,num));
    }


    @Override
    public List<PlaceRequest> getSearchAreaPlaceList(String place,int num)  {
        return touristMapper.Tourist_To_DTO(categoryDAO.searchAreaPlace(place,num));
    }

    @Override
    public List<PlaceRequest> findTypeAndAreaPlace(String cat, String areaCode, int num) {

        return  touristMapper.Tourist_To_DTO(categoryDAO.findTypeAndAreaPlace(cat,areaCode,num));
    }


    @Override
    public List<PlaceRequest> getTypePlaceList(String cat,int num) {

        return touristMapper.Tourist_To_DTO(categoryDAO.findTypePlace(cat,num));
    }

    @Override
    public List<PlaceRequest> getSearchPlace(int num, String text) {
        return  touristMapper.Tourist_To_DTO(searchDAO.searchPlace(num,text));
    }
    @Override
    public List<FoodRequest> getAreaFoodList(int num, String  areaCode) throws IOException {
        return foodMapper.Food_To_DTO(categoryDAO.findAreaFood(num,areaCode));
    }
    @Override
    @Async("taskExecutor")
    public void saveLog(LogResponse logResponse) {
        PlaceLog title = new PlaceLog(logResponse.getTitle());
        logQueue.add(title);

        // 로그가 20개 이상이면 즉시 저장 실행
        log.info( String.valueOf(logQueue.size()));
        if (logQueue.size() >= BATCH_SIZE) {
            saveLogsToElasticsearch();
        }

    }

    @Override
    public List<String> getPopularPlace() {
        return searchDAO.searchPopularPlace();
    }

    private void saveLogsToElasticsearch() {
        if (logQueue.isEmpty()) return;

        List<PlaceLog> batchLogs = new ArrayList<>();
        while (!logQueue.isEmpty() && batchLogs.size() < BATCH_SIZE) {
            batchLogs.add(logQueue.poll());
        }

        if (!batchLogs.isEmpty()) {

            searchDAO.saveSearchLog(batchLogs);
        }
    }
    @Scheduled(fixedRate = 5000)
    @Async("taskExecutor")
    public void flushLogs() {
        saveLogsToElasticsearch();

    }

}

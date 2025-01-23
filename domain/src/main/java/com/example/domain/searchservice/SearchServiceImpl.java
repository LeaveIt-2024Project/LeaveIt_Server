package com.example.domain.searchservice;

import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.domain.document.dao.SearchDAO;
import com.example.domain.mapper.FoodMapper;
import com.example.domain.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl  implements  SearchService{

    private  final SearchDAO searchDAO;

    private  final FoodMapper foodMapper;
    private  final PlaceMapper touristMapper;
    @Override
    public List<PlaceRequest> getAreaPlaceList(String area,int num)  {
        return touristMapper.Tourist_To_DTO(searchDAO.findAreaPlace(area,num));
    }


    @Override
    public List<PlaceRequest> getSearchAreaPlaceList(String place,int num)  {
        return touristMapper.Tourist_To_DTO(searchDAO.searchAreaPlace(place,num));
    }

    @Override
    public List<PlaceRequest> getTypePlaceList(String cat, int num) {

        return touristMapper.Tourist_To_DTO(searchDAO.findTypePlace(cat,num));
    }

    @Override
    public List<FoodRequest> getAreaFoodList(int num, String  areaCode) throws IOException {
        return foodMapper.Food_To_DTO(searchDAO.findAreaFood(num,areaCode));
    }
}

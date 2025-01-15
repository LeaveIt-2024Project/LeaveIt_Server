package com.example.domain.searchservice;

import com.example.common.model.request.TouristRequest;
import com.example.domain.document.dao.SearchDAO;
import com.example.domain.mapper.TouristMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SearchServiceImpl  implements  SearchService{

    private  final SearchDAO searchDAO;

    private  final TouristMapper touristMapper;
    @Override
    public List<TouristRequest> getTourist() throws IOException {
        return touristMapper.Tourist_To_DTO(searchDAO.findTouristAll());
    }
}

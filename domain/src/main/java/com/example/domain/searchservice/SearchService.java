package com.example.domain.searchservice;

import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.common.model.response.LogResponse;
import com.example.domain.document.Place;
import com.example.domain.document.PlaceLog;

import java.io.IOException;
import java.util.List;

public interface SearchService {

    List<PlaceRequest> getAreaPlaceList(String area,int num);

    List<PlaceRequest> getSearchAreaPlaceList(String place,int num);

    List<PlaceRequest> findTypeAndAreaPlace(String cat,String areaCode,int num);

    List<PlaceRequest> getTypePlaceList(String cat,int num);

    List<PlaceRequest> getSearchPlace(int num, String text);

    void saveLog(LogResponse logResponse);


    List<String> getPopularPlace();

    List<FoodRequest> getAreaFoodList(int num, String areaCode) throws IOException;
}

package com.example.domain.searchservice;

import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.domain.document.Place;

import java.io.IOException;
import java.util.List;

public interface SearchService {

    List<PlaceRequest> getAreaPlaceList(String area,int num);

    List<PlaceRequest> getSearchAreaPlaceList(String place,int num);

    List<PlaceRequest> getTypePlaceList(String cat,int num);

    List<FoodRequest> getAreaFoodList(int num, String areaCode) throws IOException;
}

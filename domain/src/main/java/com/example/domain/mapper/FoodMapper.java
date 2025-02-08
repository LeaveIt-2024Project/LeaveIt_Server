package com.example.domain.mapper;

import com.example.common.model.request.FoodRequest;
import com.example.common.model.request.PlaceRequest;
import com.example.domain.document.Food;
import com.example.domain.document.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodMapper {


    public List<FoodRequest> Food_To_DTO(List<Food> s){
        return s.stream()
                .map(t -> FoodRequest.builder()
                        .addr(t.getAddr())
                        .contentid(t.getContentid())
                        .contenttypeid(t.getContenttypeid())
                        .title(t.getTitle())
                        .tel(t.getTel())
                        .areaCode(t.getAreaCode())
                        .restrauntImage(t.getRestrauntImage())
                        .langitutde(t.getLangitutde())
                        .longtitude(t.getLongtitude())
                        .build())
                .collect(Collectors.toList());}
}

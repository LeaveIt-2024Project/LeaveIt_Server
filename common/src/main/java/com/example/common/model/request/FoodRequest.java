package com.example.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FoodRequest {

    private  String id;

    private String areaCode;


    private  String title;

    private  String contenttypeid;

    private  String addr;


    private  String contentid;

    private  String restrauntImage;


    private  Double longtitude;


    private  Double langitutde;

    private  String tel;
}

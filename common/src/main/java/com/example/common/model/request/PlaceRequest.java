package com.example.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceRequest {



    private String areaCode;

    private  String  cat;

    private  String title;

    private  String addr1;

    private  String contentId;

    private  String firstImage;

    private  String mapX;

    private  String  mapY;

    private  String tel;
}

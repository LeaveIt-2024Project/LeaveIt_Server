package com.example.domain.document;


import jakarta.persistence.Id;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "place")
public class Place {

    @Id
    private  String id;

    private String areaCode;

    private String  cat;

    private  String title;

    private  String addr1;

    private  String  contenttypeid;

    private  String contentid;

    private  String firstimage;


    private  Double longtitude;


    private  Double langitutde;

    private  String tel;

}

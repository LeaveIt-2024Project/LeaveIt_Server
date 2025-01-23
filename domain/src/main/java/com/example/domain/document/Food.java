package com.example.domain.document;

import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "food")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
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

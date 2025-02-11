package com.example.common.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelDestination {

    private String title;
    private String pcUrl;
    private String moUrl;
    private String imageUrl;
}

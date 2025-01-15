package com.example.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristRequest {

    private  String id;

    private String username;

    private  String title;

    private  String description;
}

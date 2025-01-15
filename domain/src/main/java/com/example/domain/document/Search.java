package com.example.domain.document;


import jakarta.persistence.Id;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "test")
public class Search {

    @Id
    private  String id;

    private String username;

    private  String title;

    private  String description;


}

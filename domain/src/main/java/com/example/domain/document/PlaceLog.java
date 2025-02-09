package com.example.domain.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Data
@Document(indexName = "placelog")
@AllArgsConstructor
@NoArgsConstructor
public class PlaceLog {

    @Id
    private  String id;

    private  String title;


    private LocalDateTime createdAt;

    public PlaceLog(String title) {
        this.title = title;
    }

}

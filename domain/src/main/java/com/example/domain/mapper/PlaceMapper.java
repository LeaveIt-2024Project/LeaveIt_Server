package com.example.domain.mapper;

import com.example.common.model.request.PlaceRequest;
import com.example.domain.document.Place;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
@AllArgsConstructor
public class PlaceMapper {


    public List<PlaceRequest> Tourist_To_DTO(List<Place> s){
        return s.stream()
                .map(t -> PlaceRequest.builder()
                        .contentId(t.getContentid())
                        .cat(t.getCat())
                        .areaCode(t.getAreacode())
                        .addr1(t.getAddr1())
                        .title(t.getTitle())
                        .tel(t.getTel())
                        .firstImage(t.getFirstimage())
                        .mapX(t.getMapx())
                        .mapY(t.getMapy())
                        .build())
                .collect(Collectors.toList());
    }
}

package com.example.domain.mapper;

import com.example.common.model.request.ReviewRequest;
import com.example.common.model.request.TouristRequest;
import com.example.common.model.response.LikeReview;
import com.example.domain.document.Search;
import com.example.domain.entity.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Component
@AllArgsConstructor
public class TouristMapper {


    public List<TouristRequest> Tourist_To_DTO(List<Search> s){
        return s.stream()
                .map(t -> TouristRequest.builder()
                        .id(t.getId())
                        .username(t.getUsername())
                        .title(t.getTitle())
                        .description(t.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}

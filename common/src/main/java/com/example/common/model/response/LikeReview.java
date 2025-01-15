package com.example.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeReview {

    private String  feedUID;

    private  String kaKaoUID;

    private  String userUID;

    private Boolean isLiked;

    private LocalDateTime createdAt;

}

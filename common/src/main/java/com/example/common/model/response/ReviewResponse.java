package com.example.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class ReviewResponse {


    private String  feedUID;

    private  String kaKaoUID;

    private  String userUID;

    private String nickname;

    private  String content;

    private String feedImage;

    private  Integer likeCount;

    private  Integer starCount;

    private  String placeArea;

    private Boolean isUserLiked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}

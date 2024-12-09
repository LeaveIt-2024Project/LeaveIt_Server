package com.LeaveIt.server.controller.model.response;

import com.LeaveIt.server.repository.entity.Review;
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




    public Review DTO_To_Review(ReviewResponse response){


        log.info(response.toString());
        return Review.builder()
                .feedUID(UUID.randomUUID().toString())
                .userUID(response.getUserUID())
                .kaKaoUID(response.getKaKaoUID())
                .nickname(response.getNickname())
                .content(response.getContent())
                .feedImage(response.getFeedImage())
                .likeCount(response.getLikeCount())
                .starCount(response.getStarCount())
                .placeArea(response.getPlaceArea())
                .isUserLiked(response.getIsUserLiked())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

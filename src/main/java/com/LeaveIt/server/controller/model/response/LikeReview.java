package com.LeaveIt.server.controller.model.response;

import com.LeaveIt.server.repository.entity.Like;
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
    public Like DTO_To_Like(LikeReview likeReview){
        return  Like.builder()
                .id(UUID.randomUUID().toString())
                .feedUID(likeReview.getFeedUID())
                .userUID(likeReview.getUserUID())
                .kaKaoUID(likeReview.getKaKaoUID())
                .createdAt(LocalDateTime.now())
                .isUserLiked(true)
                .build();
    }

    public Like DTO_To_Dislike(LikeReview likeReview){
        return  Like.builder()
                .id(UUID.randomUUID().toString())
                .feedUID(likeReview.getFeedUID())
                .userUID(likeReview.getUserUID())
                .kaKaoUID(likeReview.getKaKaoUID())
                .createdAt(LocalDateTime.now())
                .isUserLiked(false)
                .build();
    }
}

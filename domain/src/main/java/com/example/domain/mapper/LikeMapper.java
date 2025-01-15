package com.example.domain.mapper;

import com.example.domain.entity.Like;
import com.example.common.model.response.LikeReview;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
@Component
public class LikeMapper {
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

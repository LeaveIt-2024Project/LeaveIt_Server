package com.example.domain.mapper;

import com.example.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.common.model.request.ReviewRequest;
import com.example.common.model.response.ReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Component
@AllArgsConstructor
public class ReviewMapper {

    public List<ReviewRequest> Review_To_DTO(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewRequest.builder()
                        .feedUID(UUID.randomUUID().toString())
                        .feedImage(review.getFeedImage())
                        .content(review.getContent())
                        .likeCount(review.getLikeCount())
                        .starCount(review.getStarCount())
                        .placeArea(review.getPlaceArea())
                        .createdAt(review.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
    public Page<ReviewRequest> reviewToMap(Page<Review> page) {
        return    page.map(m->new ReviewRequest(
                m.getFeedUID(),
                m.getNickname(),
                m.getContent(),
                m.getLikeCount(),
                m.getPlaceArea(),
                m.getStarCount(),
                m.getRegion(),
                m.getCreatedAt()));
    }
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

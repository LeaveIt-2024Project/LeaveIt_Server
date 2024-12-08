package com.LeaveIt.server.controller.model.request;


import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.repository.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewRequest {
    private String  feedUID;

    private String nickname;

    private  String content;

    private String feedImage;

    private  Integer likeCount;

    private  Integer starCount;

    private  String placeArea;

    private Boolean isUserLiked;

    private LocalDateTime createdAt;






    public List<ReviewRequest> Review_To_DTO(List<Review> reviews) {
        return reviews.stream()
                .map(review -> ReviewRequest.builder()
                        .feedUID(UUID.randomUUID().toString())
                        .feedImage(review.getFeedImage())
                        .content(review.getContent())
                        .likeCount(review.getLikeCount())
                        .starCount(review.getStarCount())
                        .placeArea(review.getPlaceArea())
                        .isUserLiked(review.getIsUserLiked())
                        .createdAt(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
    }
}

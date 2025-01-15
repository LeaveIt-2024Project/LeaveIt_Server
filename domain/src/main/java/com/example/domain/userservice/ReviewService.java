package com.example.domain.userservice;



import com.example.common.model.request.ReviewRequest;
import com.example.common.model.response.LikeReview;
import com.example.common.model.response.ReviewResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {

    ReviewResponse saveReview(ReviewResponse feedResponse);


    List<ReviewRequest> findReview(String id);

    List<ReviewRequest> findReviewAll();

    Page<ReviewRequest> findReviewLikeDESCRegion(String region, Pageable pageable);

    Page<ReviewRequest> findReviewLatestRegion(String region, Pageable pageable);

    Page<ReviewRequest> findReviewRegionAll(String region, Pageable pageable);

    Page<ReviewRequest> findReviewStarDESCRegion(String region, Pageable pageable);
    void saveReviewLike(String feedUID , LikeReview likeReview);

    void cancelReviewLike(String feedUID, LikeReview likeReview);

    int findReviewCount(String id);

}

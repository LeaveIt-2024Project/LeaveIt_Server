package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.LikeReview;
import com.LeaveIt.server.controller.model.response.ReviewResponse;

import java.util.List;

public interface ReviewService {

    ReviewResponse saveReview(ReviewResponse feedResponse);


    List<ReviewRequest> findReview(String id);

    List<ReviewRequest> findReviewAll();

    void saveReviewLike(String feedUID , LikeReview likeReview);

    void cancelReviewLike(String feedUID, LikeReview likeReview);

    int findReviewCount(String id);

}

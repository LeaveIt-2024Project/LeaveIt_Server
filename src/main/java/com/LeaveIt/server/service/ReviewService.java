package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.repository.entity.Review;

import java.util.List;

public interface ReviewService {

    ReviewResponse saveFeed(ReviewResponse feedResponse);


    List<ReviewRequest> findFeed(String id);

}

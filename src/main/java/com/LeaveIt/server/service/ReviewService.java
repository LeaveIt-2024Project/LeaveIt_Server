package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.ReviewResponse;

public interface ReviewService {

    ReviewResponse saveFeed(ReviewResponse feedResponse);

}

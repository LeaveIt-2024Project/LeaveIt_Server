package com.LeaveIt.server.service;

<<<<<<< HEAD
import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.repository.entity.Review;

import java.util.List;
=======
import com.LeaveIt.server.controller.model.response.ReviewResponse;
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화

public interface ReviewService {

    ReviewResponse saveFeed(ReviewResponse feedResponse);

<<<<<<< HEAD

    List<ReviewRequest> findFeed(String id);

=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
}

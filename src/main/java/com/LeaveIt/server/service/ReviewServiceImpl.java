package com.LeaveIt.server.service;


import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public ReviewResponse saveFeed(ReviewResponse feedResponse) {

        ReviewResponse response = new ReviewResponse();
        reviewRepository.save(response.DTO_To_Review(feedResponse));
        return feedResponse;
    }

    @Override
    public List<ReviewRequest> findFeed(String id) {
        ReviewRequest reviewRequest = new ReviewRequest();
        return reviewRequest.Review_To_DTO(reviewRepository.findAllByUserReview(id));
    }

}
package com.LeaveIt.server.service;


<<<<<<< HEAD
import com.LeaveIt.server.controller.model.request.ReviewRequest;
=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

<<<<<<< HEAD

    private final ReviewRepository reviewRepository;

=======
    private  final ReviewRepository reviewRepository;
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
    @Override
    @Transactional
    public ReviewResponse saveFeed(ReviewResponse feedResponse) {

<<<<<<< HEAD
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
=======
        ReviewResponse response=new ReviewResponse();
        reviewRepository.save(response.DTO_To_Review(feedResponse));
        return  feedResponse;
    }
}
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화

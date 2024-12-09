package com.LeaveIt.server.service;


import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.controller.model.response.LikeReview;
import com.LeaveIt.server.controller.model.response.ReviewResponse;
import com.LeaveIt.server.exception.ErrorCode;
import com.LeaveIt.server.exception.ReviewException;
import com.LeaveIt.server.repository.LikeRepository;
import com.LeaveIt.server.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepository reviewRepository;

    private final LikeRepository likeRepository;

    @Override
    @Transactional
    public ReviewResponse saveReview(ReviewResponse feedResponse) {

        ReviewResponse response = new ReviewResponse();
        reviewRepository.save(response.DTO_To_Review(feedResponse));
        return feedResponse;
    }

    @Override
    public List<ReviewRequest> findReview(String id) {
        ReviewRequest reviewRequest = new ReviewRequest();
        return reviewRequest.Review_To_DTO(reviewRepository.findAllByUserReview(id));
    }

    @Override
    public List<ReviewRequest> findReviewAll() {

        ReviewRequest reviewRequest = new ReviewRequest();

        return reviewRequest.Review_To_DTO(reviewRepository.findAll());
    }

    @Override
    @Transactional
    public void saveReviewLike(String feedUID, LikeReview likeReview) {
        checkedLike(feedUID, likeReview);
        LikeReview like = new LikeReview();
        likeRepository.save(like.DTO_To_Like(likeReview));
        reviewRepository.saveCountLike(feedUID);

    }

    @Override
    @Transactional
    public void cancelReviewLike(String feedUID, LikeReview likeReview) {
         cancelLike(feedUID, likeReview);
         reviewRepository.minusCountLike(feedUID);
         likeRepository.unlikePost(feedUID,likeReview.getUserUID());
    }

    @Override
    public int findReviewCount(String id) {

        return reviewRepository.findByReviewCount(id);
    }

    private void cancelLike(String feedUID, LikeReview likeReview) {
        if (!Objects.equals(reviewRepository.findByReviewId(feedUID), feedUID)) {

            throw new ReviewException(ErrorCode.REVIEW_NOT_FOUND);
        }
        if (!likeRepository.existsByLiked(likeReview.getUserUID())){
            throw  new ReviewException(ErrorCode.LIKE_NOT_FOUND);
        }
    }

    private boolean checkedLike(String feedUID, LikeReview likeReview) {
        if (!Objects.equals(reviewRepository.findByReviewId(feedUID), feedUID)) {
            throw new ReviewException(ErrorCode.REVIEW_NOT_FOUND);
        }
//        if (likeRepository.findByFeedUIDAndUserUID(feedUID, likeReview.getUserUID())){
//            throw new ReviewException(ErrorCode.ALREADY_LIKE_FAIR);
//        }
        if(likeRepository.existsByLiked(likeReview.getUserUID())){
            throw new ReviewException(ErrorCode.ALREADY_LIKE_FAIR);
        }

        return true;

    }
}


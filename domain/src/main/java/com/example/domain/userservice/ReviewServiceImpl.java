package com.example.domain.userservice;



import com.example.domain.entity.Review;
import com.example.common.exception.ErrorCode;
import com.example.common.exception.ReviewException;
import com.example.domain.mapper.LikeMapper;
import com.example.domain.mapper.ReviewMapper;
import com.example.domain.entity.repository.LikeRepository;
import com.example.domain.entity.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import com.example.common.model.request.ReviewRequest;
import com.example.common.model.response.LikeReview;
import com.example.common.model.response.ReviewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepository reviewRepository;

    private final LikeRepository likeRepository;
    private final ReviewMapper reviewMapper;

    private  final LikeMapper likeMapper;

    @Override
    @Transactional
    public ReviewResponse saveReview(ReviewResponse feedResponse) {
        reviewRepository.save(reviewMapper.DTO_To_Review(feedResponse));
        return feedResponse;
    }

    @Override
    public List<ReviewRequest> findReview(String id) {
        return reviewMapper.Review_To_DTO(reviewRepository.findAllByUserReview(id));
    }

    @Override
    public List<ReviewRequest> findReviewAll() {

        return  reviewMapper.Review_To_DTO(reviewRepository.findAll());
    }

    @Override
    public Page<ReviewRequest> findReviewLikeDESCRegion(String region, Pageable pageable) {


        Page<Review> page=reviewRepository.findAllByRegionLikeDESCReview(region,pageable);
        return   reviewMapper.reviewToMap(page);
    }

    @Override
    public Page<ReviewRequest> findReviewLatestRegion(String region, Pageable pageable) {

         Page<Review> page= reviewRepository.findAllByRegionLatestReview(region,pageable);
         return reviewMapper.reviewToMap(page);
    }

    @Override
    public Page<ReviewRequest> findReviewRegionAll(String region, Pageable pageable) {

        Page<Review> page=reviewRepository.findAllByRegionReview(region,pageable);
        return  reviewMapper.reviewToMap(page);
    }


    @Override
    public Page<ReviewRequest> findReviewStarDESCRegion(String region, Pageable pageable) {

        Page<Review> page=reviewRepository.findAllByRegionStarDESCReview(region,pageable);

        return  reviewMapper.reviewToMap(page);

    }

    @Override
    @Transactional
    public void saveReviewLike(String feedUID, LikeReview likeReview) {
        checkedLike(feedUID, likeReview);
        likeRepository.save(likeMapper.DTO_To_Like(likeReview));
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


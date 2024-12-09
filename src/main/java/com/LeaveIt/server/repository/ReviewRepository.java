package com.LeaveIt.server.repository;

import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.repository.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.LeaveIt.server.repository.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository  extends JpaRepository<Review , String> {


    @Query(" select  r.content,r.feedImage,r.likeCount,r.placeArea,r.starCount,r.feedImage   from Review r where :kakaoUID=r.kaKaoUID")
     Review findByUserKaKaoReview(@Param("kakaoUID") String kakaoUID);

    @Query("select r from Review r where r.userUID = :userUID")
    List<Review> findAllByUserReview(@Param("userUID") String userUID);

    @Query("select u.feedUID  from Review u where :id=u.feedUID")
    String findByReviewId(@Param("id") String id);
    @Query("select count(*) from Review r where r.userUID = :userUID")
    int findByReviewCount(@Param("userUID") String userUID);

    @Modifying
    @Transactional
    @Query("UPDATE Review r SET r.likeCount = r.likeCount + 1 WHERE r.feedUID = :feedUID")
    void  saveCountLike(@Param("feedUID") String  feedUID);


    @Modifying
    @Transactional
    @Query("UPDATE Review r SET r.likeCount = r.likeCount -1 WHERE r.feedUID = :feedUID")
    void  minusCountLike(@Param("feedUID") String  feedUID);

}

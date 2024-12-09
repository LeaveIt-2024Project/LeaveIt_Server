package com.LeaveIt.server.repository;

<<<<<<< HEAD
import com.LeaveIt.server.controller.model.request.ReviewRequest;
import com.LeaveIt.server.repository.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

=======
import com.LeaveIt.server.repository.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화

@Repository
public interface ReviewRepository  extends JpaRepository<Review , String> {

<<<<<<< HEAD

    @Query(" select  r.content,r.feedImage,r.likeCount,r.placeArea,r.starCount,r.feedImage   from Review r where :kakaoUID=r.kaKaoUID")
     Review findByUserKaKaoReview(@Param("kakaoUID") String kakaoUID);

    @Query("select r from Review r where r.userUID = :userUID")
    List<Review> findAllByUserReview(@Param("userUID") String userUID);
=======
>>>>>>> 18-feat-리뷰-등록-구현-jwt-기능-구체화
}

package com.example.domain.entity.repository;

import com.example.domain.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository  extends JpaRepository<Review, String> {


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


    @Query("select  r from Review r where  r.region= :region")
    Page<Review> findAllByRegionReview(@Param("region") String region, Pageable pageable);


    @Query("select  r from  Review  r where  r.region=:region order by r.createdAt DESC ")
    Page<Review> findAllByRegionLatestReview(@Param("region") String region, Pageable pageable);

    @Query("select  r from  Review  r where  r.region=:region order by r.likeCount DESC ")
    Page<Review>  findAllByRegionLikeDESCReview(@Param("region") String region, Pageable pageable);

    @Query("select  r from  Review  r where  r.region=:region order by r.starCount DESC ")
    Page<Review>  findAllByRegionStarDESCReview(@Param("region") String region, Pageable pageable);

}




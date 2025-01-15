package com.example.domain.entity.repository;


import com.example.domain.entity.Like;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends JpaRepository<Like,String> {


    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM Like f WHERE f.isUserLiked = true AND  f.userUID=:userUID")
    boolean existsByLiked(String userUID);


    @Query("SELECT r FROM Like r WHERE r.feedUID = :feedUID AND r.userUID = :userUID")
     String findByFeedUIDAndUserUID(@Param("feedUID") String feedUID, @Param("userUID") String userUID);


    @Modifying
    @Transactional
    @Query("UPDATE Like l SET l.isUserLiked = false WHERE l.userUID = :userUID AND l.feedUID = :feedUID")
    void unlikePost(@Param("feedUID") String feedUID, @Param("userUID") String userUID);


}

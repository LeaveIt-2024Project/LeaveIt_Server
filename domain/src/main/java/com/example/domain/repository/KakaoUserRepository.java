package com.example.domain.repository;


import com.example.domain.entity.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KakaoUserRepository  extends JpaRepository<KakaoUser,String> {

    @Query("select u.kakaoUID  from kakaouser u where :kakaoUID=u.kakaoUID")
    String findByUserKaKaoId(@Param("kakaoUID") String kakaoUID);


}

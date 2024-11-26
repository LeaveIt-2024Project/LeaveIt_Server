package com.LeaveIt.server.repository;

import com.LeaveIt.server.repository.entity.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
@Repository
public interface KakaoUserRepository  extends JpaRepository<KakaoUser,String> {

    @Query("select u.kakaoUID  from kakaouser u where :kakaoUID=u.kakaoUID")
    String findByUserKaKaoId(@Param("kakaoUID") String kakaoUID);


}

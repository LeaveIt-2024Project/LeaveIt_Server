package com.LeaveIt.server.repository.entity;

import com.LeaveIt.server.controller.model.response.UserJoin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "kakaouser")
public class KakaoUser {
    @Id
    private String kakaoUID;

    private  String nickname;

    @Column(name = "profileimage")
    @Lob
    private String profileImage;

    @Column(name = "preferregion")
    private String preferRegion;


    @Column(name = "createdat")
    private LocalDateTime createdAt;


    @Column(name = "updatedat")
    private LocalDateTime  updatedAt;

    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;


    public KakaoUser KaKaoJoinToEntity(UserJoin user){
        return KakaoUser.builder()
                .kakaoUID(user.getKakaoUID())
                .nickname(user.getNickname())
                .profileImage(user.getProfileImage())
                .preferRegion(user.getPreferRegion())
                .createdAt(LocalDateTime.now())
                .build();

    }

}

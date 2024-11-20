package com.LeaveIt.server.repository.entity;


import com.LeaveIt.server.controller.model.response.UserJoinResponse;
import com.LeaveIt.server.controller.model.response.UserLoginResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class User {



    @Id
    private String userUID;


    private String id;

    private  String nickname;
    private String password;

    @Column(name = "phonenumber")
    private  String phoneNumber;


    @Column(name = "createdat")
    private LocalDateTime createdAt;


    @Column(name = "updatedat")
    private LocalDateTime  updatedAt;



    public User JoinToEntity(UserJoinResponse user){
        return User.builder()
                .userUID(user.getUserUID())
                .id(user.getId())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber()) // 필드 이름에 주의
                .createdAt(LocalDateTime.now())
                .build();
    }


//    public  User LoginToEntity(UserLoginResponse login){
//        return
//    }
}

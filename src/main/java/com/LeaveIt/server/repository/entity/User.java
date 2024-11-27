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

    @Column(name = "profileimage")
    @Lob
    private String profileImage;

    @Column(name = "preferregion")
    private String preferRegion;

    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;






//    public  User LoginToEntity(UserLogin login){
//        return
//    }
}

package com.LeaveIt.server.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UserJoin {


    private String kakaoUID;


    private String userUID;

    private String id;

    private String password;

    private  String PhoneNumber;

    private  String nickname;

    private String profileImage;

    private LocalDateTime createdAt;


    private String preferRegion;
}

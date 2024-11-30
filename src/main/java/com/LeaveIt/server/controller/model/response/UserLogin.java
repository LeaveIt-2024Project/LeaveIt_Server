package com.LeaveIt.server.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserLogin {


    private String KakaoUID;

    private  String id;

    private  String password;

    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;

    private  String token;
}

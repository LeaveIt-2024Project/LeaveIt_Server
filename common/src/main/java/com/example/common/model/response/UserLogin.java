package com.example.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {


    private String KakaoUID;

    private  String id;

    private  String password;


    private LocalDateTime createdAt;

    private LocalDateTime lastLogin;

    private  String token;
}

package com.example.domain.userservice;


import com.example.common.jwt.JwtToken;
import com.example.common.model.response.UserJoin;
import com.example.common.model.response.UserLogin;

public interface LoginService {


    String join(UserJoin userJoinResponse);

     JwtToken login(UserLogin userLoginResponse);

    JwtToken createToken(UserLogin userLoginResponse);
     JwtToken test(UserLogin userLoginResponse);
}

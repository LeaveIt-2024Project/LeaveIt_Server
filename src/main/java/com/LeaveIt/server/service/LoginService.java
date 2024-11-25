package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import org.springframework.stereotype.Service;


public interface LoginService {


    String join(UserJoin userJoinResponse);

    String  login(UserLogin userLoginResponse);



}

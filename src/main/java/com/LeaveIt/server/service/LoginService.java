package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoinResponse;
import com.LeaveIt.server.controller.model.response.UserLoginResponse;

public interface LoginService {


    String join(UserJoinResponse userJoinResponse);

    String  login(UserLoginResponse userLoginResponse);
}

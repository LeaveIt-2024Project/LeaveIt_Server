package com.LeaveIt.server.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponse {


    private  String id;

    private  String password;

}

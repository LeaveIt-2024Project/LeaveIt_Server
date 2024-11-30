package com.LeaveIt.server.controller.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JwtToken {

    private  String grantType;

    private  String accessToken;

    private  String refreshToken;

}

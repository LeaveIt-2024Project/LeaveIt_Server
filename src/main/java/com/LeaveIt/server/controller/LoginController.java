package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.jwt.JwtToken;
import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.service.KakaoLoginServiceImpl;
import com.LeaveIt.server.service.LoginService;
import com.LeaveIt.server.service.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {


    private final LoginService defaultLoginService;
    private final LoginService kakaoLoginService;

    @GetMapping("/detail")
    public  String push(){

        return "연습중입니다";
    }


    @PostMapping("/join")
    public ResponseEntity<HttpStatus> joinUser(@RequestBody UserJoin join){

        defaultLoginService.join(join);

        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<JwtToken>  loginUser(@RequestBody UserLogin login){
        defaultLoginService.login(login);
        JwtToken jwtToken=defaultLoginService.createToken(login);
        return  ResponseEntity.ok(jwtToken);

    }


    @PostMapping("/kakaojoin")
    public ResponseEntity<HttpStatus> kaKaoJoinUser(@RequestBody UserJoin join){

        kakaoLoginService.join(join);

        return  ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping("/signin")
    public ResponseEntity<JwtToken> signIn(@RequestBody UserLogin  login) {
        String username = login.getId();
        String password = login.getPassword();
        JwtToken jwtToken = defaultLoginService.test(login);
        log.info("request username = {}, password = {}", username, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return ResponseEntity.ok(defaultLoginService.test(login));
    }


    @PostMapping("/kakaologin")
    public ResponseEntity<HttpStatus> kakaoLoginUser(@RequestBody UserLogin login){
        kakaoLoginService.login(login);
        return  ResponseEntity.ok(HttpStatus.OK);

    }
}



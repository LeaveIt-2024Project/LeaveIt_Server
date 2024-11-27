package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.service.KakaoLoginServiceImpl;
import com.LeaveIt.server.service.LoginService;
import com.LeaveIt.server.service.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public  ResponseEntity<HttpStatus>  loginUser(@RequestBody UserLogin login){
        defaultLoginService.login(login);
        return  ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping("/kakaojoin")
    public ResponseEntity<HttpStatus> kaKaoJoinUser(@RequestBody UserJoin join){

        kakaoLoginService.join(join);

        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/kakaologin")
    public ResponseEntity<HttpStatus> kaKaoLoginUser(@RequestBody UserLogin login){
        kakaoLoginService.login(login);
        return  ResponseEntity.ok(HttpStatus.OK);

    }


}



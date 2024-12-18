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

        if (defaultLoginService.join(join) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<HttpStatus>  loginUser(@RequestBody UserLogin login){

        if (defaultLoginService.login(login) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(HttpStatus.OK);

    }


    @PostMapping("/kakaojoin")
    public ResponseEntity<HttpStatus> kakaoJoinUser(@RequestBody UserJoin join){

        if (kakaoLoginService.join(join) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }

        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/kakaologin")
    public ResponseEntity<HttpStatus> kakaoLoginUser(@RequestBody UserLogin login){

        if (kakaoLoginService.login(login) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(HttpStatus.OK);
    }




}



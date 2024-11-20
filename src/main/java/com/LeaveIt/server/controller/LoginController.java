package com.LeaveIt.server.controller;


import com.LeaveIt.server.controller.model.response.UserJoinResponse;
import com.LeaveIt.server.controller.model.response.UserLoginResponse;
import com.LeaveIt.server.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class LoginController {

    private  final LoginService loginService;

    @PostMapping("/join")
    public ResponseEntity<HttpStatus> joinUser(@RequestBody UserJoinResponse join){

        if (loginService.join(join) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/login")
    public  ResponseEntity<HttpStatus>  loginUser(@RequestBody UserLoginResponse login){

        if (loginService.login(login) != "성공") {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(HttpStatus.OK);

    }




}



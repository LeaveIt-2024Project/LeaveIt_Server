package com.LeaveIt.server.config;

import com.LeaveIt.server.repository.KakaoUserRepository;
import com.LeaveIt.server.repository.UserRepository;
import com.LeaveIt.server.service.KakaoLoginServiceImpl;
import com.LeaveIt.server.service.LoginService;
import com.LeaveIt.server.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfig {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KakaoUserRepository kakaoUserRepository;
    @Bean
        public LoginService LoginService() {

            return new LoginServiceImpl(userRepository);
        }

        @Bean
        public LoginService kakaoLoginService() {

            return new KakaoLoginServiceImpl(kakaoUserRepository);
        }
    }


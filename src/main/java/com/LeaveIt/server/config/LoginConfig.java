package com.LeaveIt.server.config;

import com.LeaveIt.server.repository.KakaoUserRepository;
import com.LeaveIt.server.repository.UserRepository;
import com.LeaveIt.server.service.KakaoLoginServiceImpl;
import com.LeaveIt.server.service.LoginService;
import com.LeaveIt.server.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoginConfig {

    @Autowired
    private  AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private  JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KakaoUserRepository kakaoUserRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

        @Bean
        public LoginService LoginService() {

            return new LoginServiceImpl(passwordEncoder, authenticationManagerBuilder, jwtTokenProvider, userRepository);
        }

        @Bean
        public LoginService kakaoLoginService() {

            return new KakaoLoginServiceImpl(jwtTokenProvider, kakaoUserRepository);
        }
    }


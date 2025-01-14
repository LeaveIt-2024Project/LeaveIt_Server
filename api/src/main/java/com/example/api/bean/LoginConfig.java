package com.example.api.bean;

import com.example.common.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.domain.repository.KakaoUserRepository;
import com.example.domain.repository.UserRepository;
import com.example.domain.service.KakaoLoginServiceImpl;
import com.example.domain.service.LoginService;
import com.example.domain.service.LoginServiceImpl;


@Configuration
public class LoginConfig {


    @Autowired
    private   AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private   JwtTokenProvider jwtTokenProvider;
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


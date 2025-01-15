package com.example.domain.service;


import com.example.common.config.JwtTokenProvider;
import com.example.domain.entity.User;
import com.example.common.exception.UserException;
import com.example.common.jwt.JwtToken;
import com.example.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.common.model.response.UserJoin;
import com.example.common.model.response.UserLogin;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.common.exception.ErrorCode.*;


@Slf4j
@Service("defaultLoginService")
@RequiredArgsConstructor
public class LoginServiceImpl implements  LoginService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private  final UserRepository userRepository;

//     if (join.getId().equals(userRepository.findByUserId(join.getId()))) {
//        throw new UserException(APPID_NOT_FOUND);
//    }
    @Override
    public String join(UserJoin join) {

        if ((userRepository.findByUserId(join.getId()) == null)) {
            userRepository.save(JoinToEntity(join));
            return "성공";
        }
        throw new UserException(ALREADY_APPID_FAIR);

    }
        @Override
        public JwtToken login (UserLogin userLoginResponse) {


//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginResponse.getId(), userLoginResponse.getPassword());
//            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//            JwtToken jwtToken= jwtTokenProvider.generateToken(authentication);

            loginCheck(userLoginResponse);

            return jwtTokenProvider.createAccessToken(userLoginResponse);

    }


    @Override
    public JwtToken  test(UserLogin userLoginResponse){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginResponse.getId(), userLoginResponse.getPassword());

        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 Member 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
      //  Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
//        JwtToken jwtToken = jwtTokenProvider.generateToken(authenticationToken);

        return null;
    }


    @Override
    public JwtToken createToken(UserLogin userLoginResponse){
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginResponse.getId(), userLoginResponse.getPassword());
//        JwtToken jwtToken = jwtTokenProvider.generateToken(authenticationToken);
//        return jwtToken;

        return  null;
    }



    private String loginCheck(UserLogin login) {

        String userId = userRepository.findByUserId(login.getId());
        if (userId == null || !userId.equals(login.getId())) {
            throw new UserException(APPID_NOT_FOUND);
        }
        if (passwordCheck(login.getPassword(), userRepository.findByPassword(userId))) {
            return "성공";
//            userRepository.findByPassword(userId).equals(login.getPassword())
        }
        throw new UserException(APP_PASSWD_NOT_FOUND);
    }


    private boolean passwordCheck(String rawPassword,String storedEncryptedPassword) {
        return passwordEncoder.matches(rawPassword, storedEncryptedPassword);

    }
    public User JoinToEntity(UserJoin user){
        return User.builder()
                .userUID(user.getUserUID())
                .id(user.getId())
                .nickname(user.getNickname())
                .password(passwordEncoder.encode(user.getPassword()))
                .phoneNumber(user.getPhoneNumber())
                .profileImage(user.getProfileImage())
                .preferRegion(user.getPreferRegion())
                .createdAt(LocalDateTime.now())
                .build();
    }

}

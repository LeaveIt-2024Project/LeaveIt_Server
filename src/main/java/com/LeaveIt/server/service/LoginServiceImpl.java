package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.exception.UserException;
import com.LeaveIt.server.repository.UserRepository;
import com.LeaveIt.server.repository.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.LeaveIt.server.exception.ErrorCode.*;


@Slf4j
@Service("defaultLoginService")
@RequiredArgsConstructor
public class LoginServiceImpl implements  LoginService {

    private final PasswordEncoder passwordEncoder;

    private  final UserRepository userRepository;

//     if (join.getId().equals(userRepository.findByUserId(join.getId()))) {
//        throw new UserException(APPID_NOT_FOUND);
//    }
    @Override
    public String join(UserJoin join) {
        if ((userRepository.findByUserId(join.getId())==null) ) {
            userRepository.save(JoinToEntity(join));
            return "성공";
        }
        throw new UserException(ALREADY_APPID_FAIR);
    }

    @Override
    public String login(UserLogin userLoginResponse) {

       return loginCheck(userLoginResponse);

    }




    private String loginCheck(UserLogin login) {

        String userId = userRepository.findByUserId(login.getId());
        if (userId == null || !userId.equals(login.getId())) {
            throw new UserException(APPID_NOT_FOUND);
        }if (passwordCheck(login.getPassword(),userRepository.findByPassword(userId))){
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

package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoinResponse;
import com.LeaveIt.server.controller.model.response.UserLoginResponse;
import com.LeaveIt.server.repository.UserRepository;
import com.LeaveIt.server.repository.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements  LoginService {

    private final UserRepository userRepository;

    @Override
    public String join(UserJoinResponse join) {
        User user = new User();

        if (join.getId().equals(userRepository.findByUserId(join.getId()))){

            return "아이디가 중복됩니다";
        }
        userRepository.save(user.JoinToEntity(join));

        return  "성공";
    }

    @Override
    public String login(UserLoginResponse userLoginResponse) {

       return loginCheck(userLoginResponse);

    }

    private String loginCheck(UserLoginResponse login) {

        String userId = userRepository.findByUserId(login.getId());
        if (userId.equals(login.getId())) {
            if (userRepository.findByPassword(login.getPassword()).equals(login.getPassword())) {
                return "성공";
            } else {
                log.info(login.toString());
                return "비밀번호가 올바르지않습니다";
            }
        }
        return "아이디가 올바르지않습니다";

    }
}

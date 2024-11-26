package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.exception.UserException;
import com.LeaveIt.server.repository.UserRepository;
import com.LeaveIt.server.repository.entity.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.LeaveIt.server.exception.ErrorCode.*;


@Slf4j
@Service("defaultLoginService")
@RequiredArgsConstructor
public class LoginServiceImpl implements  LoginService {

    private  final UserRepository userRepository;

    @Override
    public String join(UserJoin join) {
        User user = new User();

        if (join.getId().equals(userRepository.findByUserId(join.getId()))){

            throw  new UserException(APPID_NOT_FOUND);
        }

        userRepository.save(user.JoinToEntity(join));
        return  "성공";
    }

    @Override
    public String login(UserLogin userLoginResponse) {

       return loginCheck(userLoginResponse);

    }

    private String loginCheck(UserLogin login) {

        String userId = userRepository.findByUserId(login.getId());
        if (userId == null || !userId.equals(login.getId())) {
            throw new UserException(APPID_NOT_FOUND);
        }if (userRepository.findByPassword(userId).equals(login.getPassword())) {
            return "성공";
        }
        throw new UserException(APP_PASSWD_NOT_FOUND);
    }
}

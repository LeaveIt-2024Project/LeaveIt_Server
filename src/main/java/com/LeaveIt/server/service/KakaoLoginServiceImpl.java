package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.repository.entity.KakaoUser;
import com.LeaveIt.server.repository.KakaoUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoLoginServiceImpl implements LoginService{


    private final  KakaoUserRepository kakaoUserRepository;

    @Override
    @Transactional
    public String join(UserJoin join) {
        KakaoUser kakaoJoin=new KakaoUser();

        log.info(join.getKakaoUID());

        if (join.getKakaoUID().equals(kakaoUserRepository.findByUserKaKaoId(join.getKakaoUID()))){

            return "아이디가 중복됩니다";
        }

        kakaoUserRepository.save(kakaoJoin.KaKaoJoinToEntity(join));


        return  "성공";
    }

    @Override
    public String login(UserLogin userLoginResponse) {

        return loginCheck(userLoginResponse);
    }


    private String loginCheck(UserLogin login) {

        if (  kakaoUserRepository.findByUserKaKaoId(login.getKakaoUID()).equals(login.getKakaoUID())) {
                return "성공";
            } else {
            return "아이디가 올바르지않습니다";
        }

    }
}

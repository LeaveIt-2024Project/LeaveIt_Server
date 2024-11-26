package com.LeaveIt.server.service;

import com.LeaveIt.server.controller.model.response.UserJoin;
import com.LeaveIt.server.controller.model.response.UserLogin;
import com.LeaveIt.server.exception.UserException;
import com.LeaveIt.server.repository.entity.KakaoUser;
import com.LeaveIt.server.repository.KakaoUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.LeaveIt.server.exception.ErrorCode.*;


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
            throw  new UserException(ALREADY_KAKAOID_FAIR);
        }
        kakaoUserRepository.save(kakaoJoin.KaKaoJoinToEntity(join));


        return  "성공";
    }
    @Override
    public String login(UserLogin userLoginResponse) {

        return loginCheck(userLoginResponse);
    }


    private String loginCheck(UserLogin login) {
        log.info("hello");
        String kakaoId= kakaoUserRepository.findByUserKaKaoId(login.getKakaoUID());
        if ( kakaoId==null ||!kakaoId.equals(login.getKakaoUID())){
            throw  new UserException(KAKAOID_NOT_FOUND);
            }  else {
            return "성공";
        }

    }
}

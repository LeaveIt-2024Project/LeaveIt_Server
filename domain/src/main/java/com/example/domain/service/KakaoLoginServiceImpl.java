package com.example.domain.service;


import com.example.common.config.JwtTokenProvider;
import com.example.domain.entity.KakaoUser;
import com.example.common.exception.UserException;
import com.example.common.jwt.JwtToken;
import com.example.domain.repository.KakaoUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.common.model.response.UserJoin;
import com.example.common.model.response.UserLogin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.common.exception.ErrorCode.ALREADY_KAKAOID_FAIR;
import static com.example.common.exception.ErrorCode.KAKAOID_NOT_FOUND;


@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoLoginServiceImpl implements LoginService{

    private final JwtTokenProvider jwtTokenProvider;

    private final KakaoUserRepository kakaoUserRepository;

    @Override
    @Transactional
    public String join(UserJoin join) {
        KakaoUser kakaoJoin=new KakaoUser();

        if (join.getKakaoUID().equals(kakaoUserRepository.findByUserKaKaoId(join.getKakaoUID()))){
            throw  new UserException(ALREADY_KAKAOID_FAIR);
        }
        kakaoUserRepository.save(kakaoJoin.KaKaoJoinToEntity(join));


        return  "성공";
    }
    @Override
    public JwtToken login(UserLogin userLoginResponse) {

//        return loginCheck(userLoginResponse);
        return  null;
    }

    @Override
    public JwtToken createToken(UserLogin userLoginResponse) {

        return  null;
    }

    @Override
    public JwtToken test(UserLogin userLoginResponse) {


        return null;
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

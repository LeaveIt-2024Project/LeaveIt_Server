package com.example.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    //400 BAD_REQUEST 잘못된 요청
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "파라미터 값을 확인해주세요."),

    //404 NOT_FOUND 잘못된 리소스 접근
    APPID_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 앱 ID 입니다."),
    KAKAOID_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 카카오 ID 입니다."),
    APP_PASSWD_NOT_FOUND(HttpStatus.NOT_FOUND, "비밀번호가 일치하지않습니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,"등록된 리뷰가 없습니다"),

    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND,"등록한 좋아요가 없습니다"),
    //409 CONFLICT 중복된 리소스
    ALREADY_APPID_FAIR(HttpStatus.CONFLICT, "이미 등록된 APP 아이디 입니다."),
    ALREADY_KAKAOID_FAIR(HttpStatus.CONFLICT, "이미 등록된 KAKAO 아이디 입니다."),
    ALREADY_LIKE_FAIR(HttpStatus.CONFLICT,"이미 좋아요를 누르셨습니다"),


    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다. 서버 팀에 연락주세요");

    private final HttpStatus status;
    private final String message;
}

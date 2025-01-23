package com.example.common.exception.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum DBErrorCode {


    DB_NOT_FOUND(HttpStatus.BAD_REQUEST, "DB 값이 존재하지않습니다."),


    ES_NOT_FOUND(HttpStatus.BAD_REQUEST, "검색하신 값이 존재하지않습니다."),



    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다. 서버 팀에 연락주세요");

    private final HttpStatus status;
    private final String message;
}

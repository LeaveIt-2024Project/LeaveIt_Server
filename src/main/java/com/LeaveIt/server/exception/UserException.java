package com.LeaveIt.server.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserException extends  RuntimeException {

    private  ErrorCode errorCode;
}

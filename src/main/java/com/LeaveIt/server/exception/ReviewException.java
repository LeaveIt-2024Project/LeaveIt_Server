package com.LeaveIt.server.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReviewException  extends  RuntimeException{

    private  ErrorCode errorCode;
}

package com.example.common.exception;

import lombok.extern.slf4j.Slf4j;
import com.example.common.model.response.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {


    @ExceptionHandler(UserException.class)
    protected ResponseEntity handlerLoginException(UserException ex) {
        return  new ResponseEntity(new ErrorDTO(ex.getErrorCode().getStatus(),ex.getErrorCode().getMessage()),ex.getErrorCode().getStatus());

    }
//    @ExceptionHandler({ Exception.class })
//    protected ResponseEntity handleServerException(Exception ex) {
//
//        return new ResponseEntity(new ErrorDTO(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    @ExceptionHandler(ReviewException.class)
    protected ResponseEntity handlerReviewException(ReviewException ex) {
        return  new ResponseEntity(new ErrorDTO(ex.getErrorCode().getStatus(),ex.getErrorCode().getMessage()),ex.getErrorCode().getStatus());

    }

}

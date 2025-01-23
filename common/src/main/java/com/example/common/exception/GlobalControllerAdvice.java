package com.example.common.exception;

import com.example.common.exception.db.DBIoException;
import com.example.common.exception.db.EsIoException;
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

    @ExceptionHandler(DBIoException.class)
    protected ResponseEntity handlerDBException(ReviewException ex) {
        return  new ResponseEntity(new ErrorDTO(ex.getErrorCode().getStatus(),ex.getErrorCode().getMessage()),ex.getErrorCode().getStatus());

    }

    @ExceptionHandler(EsIoException.class)
    protected ResponseEntity handlerEsException(ReviewException ex) {
        return  new ResponseEntity(new ErrorDTO(ex.getErrorCode().getStatus(),ex.getErrorCode().getMessage()),ex.getErrorCode().getStatus());

    }


}

package com.LeaveIt.server.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorDTO {

    private HttpStatus status;
    private String message;
}

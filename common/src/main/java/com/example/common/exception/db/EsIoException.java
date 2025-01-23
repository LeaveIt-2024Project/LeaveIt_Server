package com.example.common.exception.db;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EsIoException extends RuntimeException {

    private  DBErrorCode dbErrorCode;
}

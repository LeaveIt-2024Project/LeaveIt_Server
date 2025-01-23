package com.example.common.exception.db;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DBIoException extends  RuntimeException {

    private  DBErrorCode dbErrorCode;


}

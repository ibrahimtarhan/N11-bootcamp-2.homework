package com.tarhan.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommnetByProductNotFoundException extends RuntimeException{
    public CommnetByProductNotFoundException(String message){
        super(message);
    }
}

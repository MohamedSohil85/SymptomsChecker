package com.symptome.symptomechecker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesException extends Exception{
    private static final long serialVersionUID = 1L;
    public ResourcesException(String message) {
        super(message);
    }
}

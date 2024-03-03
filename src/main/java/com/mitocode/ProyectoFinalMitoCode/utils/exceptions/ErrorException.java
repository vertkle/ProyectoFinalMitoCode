package com.mitocode.ProyectoFinalMitoCode.utils.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorException extends Exception{
    private HttpStatus httpStatus;

    public ErrorException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

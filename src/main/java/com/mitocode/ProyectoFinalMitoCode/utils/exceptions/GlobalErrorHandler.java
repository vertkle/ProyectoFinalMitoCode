package com.mitocode.ProyectoFinalMitoCode.utils.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleMethodNotValid(MethodArgumentNotValidException ex){
        List<String>listaErrores = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        ResponseErrorDto responseError = ResponseErrorDto
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messages(listaErrores)
                .build();
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseErrorDto> handleMethodNotValid(DataIntegrityViolationException ex){
        List<String>listaErrores = Arrays.asList(ex.getCause().toString());
        ResponseErrorDto responseError = ResponseErrorDto
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messages(listaErrores)
                .build();
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ResponseErrorDto> handleMethodNotValid(ErrorException ex){
        List<String>listaErrores = Arrays.asList(ex.getMessage());
        ResponseErrorDto responseError = ResponseErrorDto
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messages(listaErrores)
                .build();
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
}

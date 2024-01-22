package com.project.appmedia.controller;

import com.project.appmedia.controller.dto.ExceptionResponseMessage;
import com.project.appmedia.exception.BusinessException;
import com.project.appmedia.exception.NotFoundException;
import com.project.appmedia.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponseMessage> runtimeExceptionHandler(RuntimeException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ExceptionResponseMessage> requestExceptionHandler(RequestException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponseMessage> notFoundExceptionHandler(NotFoundException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionResponseMessage> businessExceptionHandler(BusinessException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}

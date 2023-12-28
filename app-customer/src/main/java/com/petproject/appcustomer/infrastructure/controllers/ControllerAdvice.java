package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.infrastructure.entities.exception.ExceptionControlMessage;
import com.petproject.appcustomer.infrastructure.entities.exception.ExceptionResponseMessage;
import com.petproject.appcustomer.infrastructure.exception.BusinessException;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.exception.ResponseMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionControlMessage> runtimeExceptionHandler(RuntimeException ex) {
        ExceptionControlMessage error = ExceptionControlMessage.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ResponseMessageException.class)
    public ResponseEntity<ExceptionControlMessage> responseStatusExceptionHandler(ResponseMessageException ex) {
        ExceptionControlMessage error = ExceptionControlMessage.builder().code(ex.getCode()).message(ex.getMessage()).keyValueExceptionsMessages(ex.getKeyValueExceptionsMessages()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionResponseMessage> businessExceptionHandler(BusinessException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponseMessage> notFoundExceptionHandler(NotFoundException ex) {
        ExceptionResponseMessage error = ExceptionResponseMessage.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}

package com.project.appmedia.controller;

import com.project.appmedia.controller.dto.MessageDto;
import com.project.appmedia.exception.NotFoundException;
import com.project.appmedia.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<MessageDto> runtimeExceptionHandler(RuntimeException ex) {
        MessageDto error = MessageDto.builder().code("500").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<MessageDto> requestExceptionHandler(RequestException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<MessageDto> notFoundExceptionHandler(NotFoundException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}

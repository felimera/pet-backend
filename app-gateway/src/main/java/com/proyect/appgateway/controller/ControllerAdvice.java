package com.proyect.appgateway.controller;
import com.proyect.appgateway.controller.dto.MessageDto;
import com.proyect.appgateway.exception.AuthenticationException;
import com.proyect.appgateway.exception.BusinessException;
import com.proyect.appgateway.exception.NotFoundException;
import com.proyect.appgateway.exception.RequestException;
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

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<MessageDto> businessExceptionHandler(BusinessException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<MessageDto> notFoundExceptionHandler(NotFoundException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<MessageDto> authenticationException(AuthenticationException ex) {
        MessageDto error = MessageDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}

package com.project.appmedia.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {
    private final String code;

    public RequestException(String code, String message) {
        super(message);
        this.code = code;
    }
}
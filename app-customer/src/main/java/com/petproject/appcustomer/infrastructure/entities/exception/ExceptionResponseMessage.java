package com.petproject.appcustomer.infrastructure.entities.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponseMessage {
    private String code;
    private String message;
}

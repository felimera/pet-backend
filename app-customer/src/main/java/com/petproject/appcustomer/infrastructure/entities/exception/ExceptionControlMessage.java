package com.petproject.appcustomer.infrastructure.entities.exception;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExceptionControlMessage {
    private String code;
    private String message;
    private List<KeyValueExceptionsMessage> keyValueExceptionsMessages;
}

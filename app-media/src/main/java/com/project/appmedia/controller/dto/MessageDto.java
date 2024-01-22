package com.project.appmedia.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String code;
    private String message;
}
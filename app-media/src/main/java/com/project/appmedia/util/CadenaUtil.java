package com.project.appmedia.util;

import com.project.appmedia.models.exception.KeyValueExceptionsMessage;
import org.springframework.validation.BindingResult;

import java.util.List;

public class CadenaUtil {

    private CadenaUtil() {
        throw new IllegalStateException(CadenaUtil.class.toString());
    }

    public static String convertTrueFalse(Boolean value) {
        return value.equals(Boolean.TRUE) ? Constants.T : Constants.F;
    }

    public static List<KeyValueExceptionsMessage> formatMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(err -> KeyValueExceptionsMessage.builder().attributeName(err.getField()).attributeValue(err.getDefaultMessage()).build())
                .toList();
    }
}

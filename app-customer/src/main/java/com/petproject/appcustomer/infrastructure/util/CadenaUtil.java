package com.petproject.appcustomer.infrastructure.util;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.petproject.appcustomer.infrastructure.entities.exception.KeyValueExceptionsMessage;
import org.springframework.validation.BindingResult;

import java.util.List;

public class CadenaUtil {
    private CadenaUtil() {
        throw new IllegalStateException(CadenaUtil.class.toString());
    }

    public static String convertBodyToJson(String attributeName, Object body) {
        JsonObject json = new JsonObject();
        json.put(attributeName, body);
        return json.toString();
    }

    public static List<KeyValueExceptionsMessage> formatMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(err -> KeyValueExceptionsMessage.builder().attributeName(err.getField()).attributeValue(err.getDefaultMessage()).build())
                .toList();
    }

    public static String convertTrueFalse(Boolean value) {
        return value.equals(Boolean.TRUE) ? Constants.T : Constants.F;
    }

    public static String toUppercase(String valor) {
        if (valor == null || valor.isEmpty()) {
            return valor;
        } else {
            return valor.toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase();
        }
    }
}

package com.petproject.appcustomer.infrastructure.util.config;

import com.petproject.appcustomer.infrastructure.util.CadenaUtil;
import com.petproject.appcustomer.infrastructure.util.Constants;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        if (Objects.nonNull(aBoolean))
            return CadenaUtil.convertTrueFalse(aBoolean);
        return Constants.F;
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        if (Objects.nonNull(s))
            return s.equals(Constants.T);
        return Boolean.FALSE;
    }
}

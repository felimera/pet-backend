package com.project.appmedia.util.config;

import com.project.appmedia.util.CadenaUtil;
import com.project.appmedia.util.Constants;
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

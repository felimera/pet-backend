package com.petproject.appcustomer.infrastructure.util.config;

import com.petproject.appcustomer.domain.models.in.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.name();
    }

    @Override
    public Gender convertToEntityAttribute(String s) {
        return Gender.getName(s);
    }
}

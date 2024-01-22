package com.petproject.appcustomer.domain.models.in.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Gender {
    M("Male"), F("Female");

    private String value;

    public static Gender of(String data) {
        return Stream.of(Gender.values())
                .filter(p -> p.getValue().equals(data))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Gender getName(String data) {
        return Stream.of(Gender.values())
                .filter(p -> p.name().equals(data))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

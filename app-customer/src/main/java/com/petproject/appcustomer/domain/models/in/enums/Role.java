package com.petproject.appcustomer.domain.models.in.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Role {
    U("Usuario"), A("Administrador");

    private String value;

    public static Role of(String rol) {
        return Stream.of(Role.values())
                .filter(p -> p.getValue().equals(rol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static Role getName(String rol) {
        return Stream.of(Role.values())
                .filter(p -> p.name().equals(rol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

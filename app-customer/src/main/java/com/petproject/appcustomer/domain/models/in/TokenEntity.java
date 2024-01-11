package com.petproject.appcustomer.domain.models.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenEntity {
    private String jwtToken;
}

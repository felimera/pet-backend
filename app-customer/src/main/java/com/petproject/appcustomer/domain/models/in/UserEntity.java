package com.petproject.appcustomer.domain.models.in;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private String name;
    private String email;
}

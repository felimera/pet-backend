package com.petproject.appcustomer.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColorDTO {
    private Integer id;
    private String name;
    private String code;
    private Boolean active;
}

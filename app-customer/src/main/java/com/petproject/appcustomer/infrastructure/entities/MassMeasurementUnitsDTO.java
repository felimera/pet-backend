package com.petproject.appcustomer.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MassMeasurementUnitsDTO {
    private Integer id;
    private String name;
    private String acronym;
    private String description;
    private Boolean active;
}

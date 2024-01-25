package com.petproject.appcustomer.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RaceDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer idBodySizeEntity;
    private Integer idPetCategoryEntity;
    private Boolean active;
}

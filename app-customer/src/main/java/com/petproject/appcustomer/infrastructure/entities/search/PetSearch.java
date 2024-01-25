package com.petproject.appcustomer.infrastructure.entities.search;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PetSearch {
    private String namePet;
    private String nameOwner;
    private Integer idRaceEntity;
}

package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;

import java.util.List;

public interface RetrievePetCategoryUseCase {

    List<PetCategoryDTO> getAllPetCategory();
}

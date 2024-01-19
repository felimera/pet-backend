package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;

import java.util.List;

public interface PetCategoryRepositoryPort {

    List<PetCategoryDTO> getAllPetCategory();
}

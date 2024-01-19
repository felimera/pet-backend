package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrievePetCategoryUseCase;
import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PetCategoryService implements RetrievePetCategoryUseCase {

    private final RetrievePetCategoryUseCase retrievePetCategoryUseCase;

    @Override
    public List<PetCategoryDTO> getAllPetCategory() {
        return retrievePetCategoryUseCase.getAllPetCategory();
    }
}

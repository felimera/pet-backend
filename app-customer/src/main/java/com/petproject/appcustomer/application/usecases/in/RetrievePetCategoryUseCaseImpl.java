package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrievePetCategoryUseCase;
import com.petproject.appcustomer.domain.ports.out.PetCategoryRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrievePetCategoryUseCaseImpl implements RetrievePetCategoryUseCase {

    private final PetCategoryRepositoryPort petCategoryRepositoryPort;

    @Override
    public List<PetCategoryDTO> getAllPetCategory() {
        return petCategoryRepositoryPort.getAllPetCategory();
    }
}

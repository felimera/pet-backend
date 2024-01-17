package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.internal.CreatePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePetUseCaseImpl implements CreatePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetDTO createCustomer(PetDTO petDTO) {
        return petRepositoryPort.save(petDTO);
    }
}

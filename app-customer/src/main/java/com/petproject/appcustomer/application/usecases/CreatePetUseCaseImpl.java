package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.ports.in.CreatePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePetUseCaseImpl implements CreatePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetEntity createCustomer(PetEntity petEntity) {
        return petRepositoryPort.save(petEntity);
    }
}

package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.ports.in.UpdatePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePetUseCaseImpl implements UpdatePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetEntity updatePet(Integer id, PetEntity petEntity) {
        return petRepositoryPort.update(id, petEntity);
    }
}

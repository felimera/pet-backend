package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.DeletePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePetUseCaseImpl implements DeletePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public boolean deletePet(Integer id) {
        return petRepositoryPort.deleteById(id);
    }
}

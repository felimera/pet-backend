package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.UpdatePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePetUseCaseImpl implements UpdatePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetDTO updatePet(Integer id, PetDTO petDTO) {
        return petRepositoryPort.update(id, petDTO);
    }
}

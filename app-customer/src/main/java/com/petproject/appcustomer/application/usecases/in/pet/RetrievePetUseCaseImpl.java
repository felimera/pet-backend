package com.petproject.appcustomer.application.usecases.in.pet;

import com.petproject.appcustomer.domain.ports.in.internal.RetrievePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrievePetUseCaseImpl implements RetrievePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetDTO getPet(Integer id) {
        return petRepositoryPort.findById(id).orElseThrow();
    }

    @Override
    public List<PetDTO> getAllPet() {
        return petRepositoryPort.findAll();
    }

    @Override
    public List<PetDTO> getPetMultipleParameter(PetSearch petSearch) {
        return petRepositoryPort.getPetMultipleParameter(petSearch);
    }
}

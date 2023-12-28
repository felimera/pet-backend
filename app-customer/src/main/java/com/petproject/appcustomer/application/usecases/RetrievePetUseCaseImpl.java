package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.ports.in.RetrievePetUseCase;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrievePetUseCaseImpl implements RetrievePetUseCase {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public PetEntity getPet(Integer id) {
        return petRepositoryPort.findById(id).orElseThrow();
    }

    @Override
    public List<PetEntity> getAllPet() {
        return petRepositoryPort.findAll();
    }
}

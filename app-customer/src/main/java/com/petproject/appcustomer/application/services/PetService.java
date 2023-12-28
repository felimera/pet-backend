package com.petproject.appcustomer.application.services;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.ports.in.CreatePetUseCase;
import com.petproject.appcustomer.domain.ports.in.DeletePetUseCase;
import com.petproject.appcustomer.domain.ports.in.RetrievePetUseCase;
import com.petproject.appcustomer.domain.ports.in.UpdatePetUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PetService implements CreatePetUseCase, DeletePetUseCase, RetrievePetUseCase, UpdatePetUseCase {

    private final CreatePetUseCase createPetUseCase;
    private final DeletePetUseCase deletePetUseCase;
    private final RetrievePetUseCase retrievePetUseCase;
    private final UpdatePetUseCase updatePetUseCase;

    @Override
    public PetEntity createCustomer(PetEntity petEntity) {
        return createPetUseCase.createCustomer(petEntity);
    }

    @Override
    public boolean deletePet(Integer id) {
        return deletePetUseCase.deletePet(id);
    }

    @Override
    public PetEntity getPet(Integer id) {
        return retrievePetUseCase.getPet(id);
    }

    @Override
    public List<PetEntity> getAllPet() {
        return retrievePetUseCase.getAllPet();
    }

    @Override
    public PetEntity updatePet(Integer id, PetEntity petEntity) {
        return updatePetUseCase.updatePet(id, petEntity);
    }
}

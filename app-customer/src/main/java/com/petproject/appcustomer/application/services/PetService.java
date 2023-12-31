package com.petproject.appcustomer.application.services;

import com.petproject.appcustomer.domain.ports.in.CreatePetUseCase;
import com.petproject.appcustomer.domain.ports.in.DeletePetUseCase;
import com.petproject.appcustomer.domain.ports.in.RetrievePetUseCase;
import com.petproject.appcustomer.domain.ports.in.UpdatePetUseCase;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PetService implements CreatePetUseCase, DeletePetUseCase, RetrievePetUseCase, UpdatePetUseCase {

    private final CreatePetUseCase createPetUseCase;
    private final DeletePetUseCase deletePetUseCase;
    private final RetrievePetUseCase retrievePetUseCase;
    private final UpdatePetUseCase updatePetUseCase;

    @Override
    public PetDTO createCustomer(PetDTO petDTO) {
        return createPetUseCase.createCustomer(petDTO);
    }

    @Override
    public boolean deletePet(Integer id) {
        return deletePetUseCase.deletePet(id);
    }

    @Override
    public PetDTO getPet(Integer id) {
        return retrievePetUseCase.getPet(id);
    }

    @Override
    public List<PetDTO> getAllPet() {
        return retrievePetUseCase.getAllPet();
    }

    @Override
    public PetDTO updatePet(Integer id, PetDTO petDTO) {
        return updatePetUseCase.updatePet(id, petDTO);
    }
}

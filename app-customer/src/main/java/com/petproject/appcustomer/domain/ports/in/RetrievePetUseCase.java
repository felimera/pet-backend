package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.infrastructure.entities.PetDTO;

import java.util.List;

public interface RetrievePetUseCase {
    PetDTO getPet(Integer id);

    List<PetDTO> getAllPet();
}

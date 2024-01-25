package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;

import java.util.List;

public interface RetrievePetUseCase {
    PetDTO getPet(Integer id);

    List<PetDTO> getAllPet();

    List<PetDTO> getPetMultipleParameter(PetSearch petSearch);
}

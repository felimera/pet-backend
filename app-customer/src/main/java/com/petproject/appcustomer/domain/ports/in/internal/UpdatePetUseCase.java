package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.PetDTO;

public interface UpdatePetUseCase {
    PetDTO updatePet(Integer id, PetDTO petDTO);
}

package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.PetDTO;

public interface CreatePetUseCase {
    PetDTO createCustomer(PetDTO petDTO);
}

package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.PetEntity;

public interface UpdatePetUseCase {
    PetEntity updatePet(Long id, PetEntity petEntity);
}

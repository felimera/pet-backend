package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.PetEntity;

public interface CreatePetUseCase {
    PetEntity createCustomer(PetEntity petEntity);
}

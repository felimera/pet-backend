package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.PetEntity;

import java.util.List;

public interface RetrievePetUseCase {
    PetEntity getPet(Long id);

    List<PetEntity> getAllPet();
}

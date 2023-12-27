package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.PetEntity;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryPort {
    PetEntity save(PetEntity entity);

    Optional<PetEntity> findById(Long id);

    List<PetEntity> findAll();

    Optional<PetEntity> update(Long id, PetEntity entity);

    boolean deleteById(Long id);
}

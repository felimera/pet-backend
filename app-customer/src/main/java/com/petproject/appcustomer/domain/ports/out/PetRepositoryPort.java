package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.PetDTO;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryPort {
    PetDTO save(PetDTO dto);

    Optional<PetDTO> findById(Integer id);

    List<PetDTO> findAll();

    PetDTO update(Integer id, PetDTO dto);

    boolean deleteById(Integer id);
}

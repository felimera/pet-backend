package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.RaceDTO;

import java.util.List;

public interface RaceRepositoryPort {
    List<RaceDTO> getAllRace();
}

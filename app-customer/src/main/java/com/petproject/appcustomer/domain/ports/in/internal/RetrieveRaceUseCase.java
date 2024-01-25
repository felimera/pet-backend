package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.RaceDTO;

import java.util.List;

public interface RetrieveRaceUseCase {
    List<RaceDTO>getAllRace();
}

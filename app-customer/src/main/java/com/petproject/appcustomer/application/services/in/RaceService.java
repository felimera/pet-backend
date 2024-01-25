package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveRaceUseCase;
import com.petproject.appcustomer.infrastructure.entities.RaceDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RaceService implements RetrieveRaceUseCase {

    private final RetrieveRaceUseCase retrieveRaceUseCase;

    @Override
    public List<RaceDTO> getAllRace() {
        return retrieveRaceUseCase.getAllRace();
    }
}

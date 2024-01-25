package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveRaceUseCase;
import com.petproject.appcustomer.domain.ports.out.RaceRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.RaceDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveRaceUseCaseImpl implements RetrieveRaceUseCase {

    private final RaceRepositoryPort raceRepositoryPort;

    @Override
    public List<RaceDTO> getAllRace() {
        return raceRepositoryPort.getAllRace();
    }
}

package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveMassMeasurementUnitsUseCase;
import com.petproject.appcustomer.domain.ports.out.MassMeasurementUnitsRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveMassMeasurementUnitsUseCaseImpl implements RetrieveMassMeasurementUnitsUseCase {

    private final MassMeasurementUnitsRepositoryPort massMeasurementUnitsRepositoryPort;

    @Override
    public List<MassMeasurementUnitsDTO> getAllMassMeasurementUnits() {
        return massMeasurementUnitsRepositoryPort.getAllMassMeasurementUnits();
    }
}

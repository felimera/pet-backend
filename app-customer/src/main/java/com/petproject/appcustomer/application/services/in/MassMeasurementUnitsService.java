package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveMassMeasurementUnitsUseCase;
import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MassMeasurementUnitsService implements RetrieveMassMeasurementUnitsUseCase {

    private final RetrieveMassMeasurementUnitsUseCase retrieveMassMeasurementUnitsUseCase;

    @Override
    public List<MassMeasurementUnitsDTO> getAllMassMeasurementUnits() {
        return retrieveMassMeasurementUnitsUseCase.getAllMassMeasurementUnits();
    }
}

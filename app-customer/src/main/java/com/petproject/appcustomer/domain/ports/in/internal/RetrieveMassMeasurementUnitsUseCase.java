package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;

import java.util.List;

public interface RetrieveMassMeasurementUnitsUseCase {

    List<MassMeasurementUnitsDTO> getAllMassMeasurementUnits();
}

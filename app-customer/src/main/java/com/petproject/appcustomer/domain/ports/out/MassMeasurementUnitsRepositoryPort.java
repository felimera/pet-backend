package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;

import java.util.List;

public interface MassMeasurementUnitsRepositoryPort {

    List<MassMeasurementUnitsDTO> getAllMassMeasurementUnits();
}

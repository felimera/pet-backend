package com.petproject.appcustomer.infrastructure.repositories.massunits;

import com.petproject.appcustomer.domain.models.in.MassMeasurementUnitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaMassMeasurementUnitsRepository extends JpaRepository<MassMeasurementUnitsEntity, Integer> {

    List<MassMeasurementUnitsEntity> findAllByActive(Boolean active);
}

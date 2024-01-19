package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.MassMeasurementUnitsEntity;
import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MassMeasurementUnitsMapper {

    MassMeasurementUnitsMapper INSTANCE = Mappers.getMapper(MassMeasurementUnitsMapper.class);

    MassMeasurementUnitsEntity fromDomainModel(MassMeasurementUnitsDTO dto);

    @InheritInverseConfiguration
    MassMeasurementUnitsDTO toDomainModel(MassMeasurementUnitsEntity entity);
}

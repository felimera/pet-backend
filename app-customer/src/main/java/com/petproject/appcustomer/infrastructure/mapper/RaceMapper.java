package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.RaceEntity;
import com.petproject.appcustomer.infrastructure.entities.RaceDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RaceMapper {
    RaceMapper INSTANCE = Mappers.getMapper(RaceMapper.class);

    RaceEntity fromDomainModel(RaceDTO dto);

    @InheritInverseConfiguration
    RaceDTO toDomainModel(RaceEntity entity);
}

package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper {
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    PetEntity fromDomainModel(PetDTO dto);

    @InheritInverseConfiguration
    PetDTO toDomainModel(PetEntity entity);
}

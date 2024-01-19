package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.PetCategoryEntity;
import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetCategoryMapper {

    PetCategoryMapper INSTANCE = Mappers.getMapper(PetCategoryMapper.class);

    PetCategoryEntity fromDomainModel(PetCategoryDTO dto);

    @InheritInverseConfiguration
    PetCategoryDTO toDomainModel(PetCategoryEntity entity);
}

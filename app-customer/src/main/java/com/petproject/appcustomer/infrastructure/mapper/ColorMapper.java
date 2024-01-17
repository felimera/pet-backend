package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.ColorEntity;
import com.petproject.appcustomer.infrastructure.entities.ColorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ColorMapper {
    ColorMapper INSTANCE = Mappers.getMapper(ColorMapper.class);

    ColorEntity fromDomainModel(ColorDTO dto);

    @InheritInverseConfiguration
    ColorDTO toDomainModel(ColorEntity entity);
}

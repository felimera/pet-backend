package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.BodySizeEntity;
import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BodySizeMapper {

    BodySizeMapper INSTANCE = Mappers.getMapper(BodySizeMapper.class);

    BodySizeEntity fromDomainModel(BodySizeDTO dto);

    @InheritInverseConfiguration
    BodySizeDTO toDomainModel(BodySizeEntity entity);
}

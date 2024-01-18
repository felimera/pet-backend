package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.TypeFigureEntity;
import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeFigureMapper {

    TypeFigureMapper INSTANCE = Mappers.getMapper(TypeFigureMapper.class);

    TypeFigureEntity fromDomainModel(TypeFigureDTO dto);

    @InheritInverseConfiguration
    TypeFigureDTO toDomainModel(TypeFigureEntity entity);
}

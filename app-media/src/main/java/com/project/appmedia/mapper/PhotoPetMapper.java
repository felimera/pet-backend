package com.project.appmedia.mapper;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import com.project.appmedia.models.PhotoPet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoPetMapper {


    PhotoPetMapper INSTANCE = Mappers.getMapper(PhotoPetMapper.class);

    PhotoPet fromDomainModel(PhotoPetDTO dto);

    @InheritInverseConfiguration
    PhotoPetDTO toDomainModel(PhotoPet entity);
}

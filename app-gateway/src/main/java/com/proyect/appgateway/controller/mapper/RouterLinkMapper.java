package com.proyect.appgateway.controller.mapper;

import com.proyect.appgateway.controller.dto.RouterLinkDto;
import com.proyect.appgateway.models.RouterLink;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouterLinkMapper {

    RouterLinkMapper INSTANCE = Mappers.getMapper(RouterLinkMapper.class);

    RouterLinkDto toDto(RouterLink entity);
}
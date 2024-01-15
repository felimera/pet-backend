package com.proyect.appgateway.controller.mapper;

import com.proyect.appgateway.controller.dto.UserDto;
import com.proyect.appgateway.controller.dto.auth.SignUpDto;
import com.proyect.appgateway.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

    User toSignUp(SignUpDto signUpDto);
}

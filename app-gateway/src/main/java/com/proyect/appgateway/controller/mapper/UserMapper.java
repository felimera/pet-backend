package com.proyect.appgateway.controller.mapper;

import com.proyect.appgateway.controller.dto.UserDto;
import com.proyect.appgateway.controller.dto.auth.SignUpDto;
import com.proyect.appgateway.models.User;
import com.proyect.appgateway.util.Constants;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    @InheritInverseConfiguration
    User toEntity(UserDto userDto);

    @Mapping(target = "name", expression = "java(getNombres(signUpDto))")
    User toSignUp(SignUpDto signUpDto);

    default String getNombres(SignUpDto signUpDto) {
        return signUpDto.getNombres().replace(Constants.AMPERSAND, Constants.SPACE);
    }
}

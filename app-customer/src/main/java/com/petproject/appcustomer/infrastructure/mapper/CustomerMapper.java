package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.util.CadenaUtil;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "isOlder", expression = "java(isOlderConvert(dto))")
    CustomerEntity fromDomainModel(CustomerDTO dto);

    @InheritInverseConfiguration
    CustomerDTO toDomainModel(CustomerEntity entity);

    default String isOlderConvert(CustomerDTO dto) {
        return CadenaUtil.convertTrueFalse(dto.getIsOlder());
    }
}

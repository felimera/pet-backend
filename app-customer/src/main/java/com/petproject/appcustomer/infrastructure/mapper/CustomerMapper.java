package com.petproject.appcustomer.infrastructure.mapper;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity fromDomainModel(CustomerDTO dto);

    @InheritInverseConfiguration
    CustomerDTO toDomainModel(CustomerEntity entity);
}

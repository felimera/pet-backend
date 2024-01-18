package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;

import java.util.List;

public interface BodySizeRepositoryPort {

    List<BodySizeDTO> getAllBodySize();
}

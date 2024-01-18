package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;

import java.util.List;

public interface RetrieveBodySizeUseCase {

    List<BodySizeDTO> getAllBodySize();
}

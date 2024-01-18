package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveBodySizeUseCase;
import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BodySizeService implements RetrieveBodySizeUseCase {

    private final RetrieveBodySizeUseCase retrieveBodySizeUseCase;

    @Override
    public List<BodySizeDTO> getAllBodySize() {
        return retrieveBodySizeUseCase.getAllBodySize();
    }
}

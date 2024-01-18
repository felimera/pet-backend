package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveBodySizeUseCase;
import com.petproject.appcustomer.domain.ports.out.BodySizeRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveBodySizeUseCaseImpl implements RetrieveBodySizeUseCase {

    private final BodySizeRepositoryPort bodySizeRepositoryPort;

    @Override
    public List<BodySizeDTO> getAllBodySize() {
        return bodySizeRepositoryPort.getAllBodySize();
    }
}

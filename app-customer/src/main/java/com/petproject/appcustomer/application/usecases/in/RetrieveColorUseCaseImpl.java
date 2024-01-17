package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveColorUseCase;
import com.petproject.appcustomer.domain.ports.out.ColorRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.ColorDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveColorUseCaseImpl implements RetrieveColorUseCase {

    private final ColorRepositoryPort colorRepositoryPort;

    @Override
    public List<ColorDTO> getAllColor() {
        return colorRepositoryPort.getAllColor();
    }
}

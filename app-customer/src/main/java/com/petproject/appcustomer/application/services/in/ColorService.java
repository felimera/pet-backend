package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveColorUseCase;
import com.petproject.appcustomer.infrastructure.entities.ColorDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ColorService implements RetrieveColorUseCase {

    private final RetrieveColorUseCase retrieveColorUseCase;

    @Override
    public List<ColorDTO> getAllColor() {
        return retrieveColorUseCase.getAllColor();
    }
}

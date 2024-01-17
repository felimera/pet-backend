package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.ColorDTO;

import java.util.List;

public interface RetrieveColorUseCase {

    List<ColorDTO> getAllColor();
}

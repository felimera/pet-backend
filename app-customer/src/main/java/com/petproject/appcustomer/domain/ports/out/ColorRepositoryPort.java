package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.ColorDTO;

import java.util.List;

public interface ColorRepositoryPort {

    List<ColorDTO> getAllColor();
}

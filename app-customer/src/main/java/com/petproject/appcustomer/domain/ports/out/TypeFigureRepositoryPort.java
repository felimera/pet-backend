package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;

import java.util.List;

public interface TypeFigureRepositoryPort {

    List<TypeFigureDTO> getAllTypeFigure();
}

package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;

import java.util.List;

public interface RetrieveTypeFigureUseCase {

    List<TypeFigureDTO> getAllTypeFigure();
}

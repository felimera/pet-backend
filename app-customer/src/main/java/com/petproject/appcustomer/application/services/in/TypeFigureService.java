package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveTypeFigureUseCase;
import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TypeFigureService implements RetrieveTypeFigureUseCase {

    private final RetrieveTypeFigureUseCase retrieveTypeFigureUseCase;

    @Override
    public List<TypeFigureDTO> getAllTypeFigure() {
        return retrieveTypeFigureUseCase.getAllTypeFigure();
    }
}

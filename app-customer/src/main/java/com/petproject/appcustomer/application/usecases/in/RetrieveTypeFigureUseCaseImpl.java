package com.petproject.appcustomer.application.usecases.in;

import com.petproject.appcustomer.domain.ports.in.internal.RetrieveTypeFigureUseCase;
import com.petproject.appcustomer.domain.ports.out.TypeFigureRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveTypeFigureUseCaseImpl implements RetrieveTypeFigureUseCase {

    private final TypeFigureRepositoryPort typeFigureRepositoryPort;

    @Override
    public List<TypeFigureDTO> getAllTypeFigure() {
        return typeFigureRepositoryPort.getAllTypeFigure();
    }
}

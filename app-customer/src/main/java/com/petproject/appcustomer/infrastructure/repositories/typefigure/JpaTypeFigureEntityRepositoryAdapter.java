package com.petproject.appcustomer.infrastructure.repositories.typefigure;

import com.petproject.appcustomer.domain.models.in.TypeFigureEntity;
import com.petproject.appcustomer.domain.ports.out.TypeFigureRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.TypeFigureDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.TypeFigureMapper;
import com.petproject.appcustomer.infrastructure.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaTypeFigureEntityRepositoryAdapter implements TypeFigureRepositoryPort {

    private final JpaTypeFigureEntityRepository jpaTypeFigureEntityRepository;

    @Override
    public List<TypeFigureDTO> getAllTypeFigure() {
        List<TypeFigureEntity> typeFigureEntities = jpaTypeFigureEntityRepository.getAllTypeFigureByActive(Boolean.TRUE);
        if (typeFigureEntities.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "201-01", HttpStatus.NOT_FOUND);
        return typeFigureEntities.stream().map(TypeFigureMapper.INSTANCE::toDomainModel).toList();
    }
}

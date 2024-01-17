package com.petproject.appcustomer.infrastructure.repositories.color;

import com.petproject.appcustomer.domain.models.in.ColorEntity;
import com.petproject.appcustomer.domain.ports.out.ColorRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.ColorDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.ColorMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaColorEntityRepositoryAdapter implements ColorRepositoryPort {

    private final JpaColorEntityRepository jpaColorEntityRepository;

    @Override
    public List<ColorDTO> getAllColor() {
        List<ColorEntity> colorEntities = jpaColorEntityRepository.findAllByActive(Boolean.TRUE);
        if (colorEntities.isEmpty())
            throw new NotFoundException("No customer records found.", "201-01", HttpStatus.NOT_FOUND);
        return colorEntities
                .stream()
                .map(ColorMapper.INSTANCE::toDomainModel)
                .toList();
    }
}

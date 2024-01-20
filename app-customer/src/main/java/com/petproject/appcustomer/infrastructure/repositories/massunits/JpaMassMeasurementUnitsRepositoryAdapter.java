package com.petproject.appcustomer.infrastructure.repositories.massunits;

import com.petproject.appcustomer.domain.models.in.MassMeasurementUnitsEntity;
import com.petproject.appcustomer.domain.ports.out.MassMeasurementUnitsRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.MassMeasurementUnitsDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.MassMeasurementUnitsMapper;
import com.petproject.appcustomer.infrastructure.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaMassMeasurementUnitsRepositoryAdapter implements MassMeasurementUnitsRepositoryPort {

    private JpaMassMeasurementUnitsRepository jpaMassMeasurementUnitsRepository;

    @Override
    public List<MassMeasurementUnitsDTO> getAllMassMeasurementUnits() {
        List<MassMeasurementUnitsEntity> massMeasurementUnitsEntities = jpaMassMeasurementUnitsRepository.findAllByActive(Boolean.TRUE);
        if (massMeasurementUnitsEntities.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "201-01", HttpStatus.NOT_FOUND);
        return massMeasurementUnitsEntities
                .stream()
                .map(MassMeasurementUnitsMapper.INSTANCE::toDomainModel)
                .toList();
    }
}

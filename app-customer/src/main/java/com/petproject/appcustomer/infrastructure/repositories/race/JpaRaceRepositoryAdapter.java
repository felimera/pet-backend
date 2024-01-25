package com.petproject.appcustomer.infrastructure.repositories.race;

import com.petproject.appcustomer.domain.models.in.RaceEntity;
import com.petproject.appcustomer.domain.ports.out.RaceRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.RaceDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.RaceMapper;
import com.petproject.appcustomer.infrastructure.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaRaceRepositoryAdapter implements RaceRepositoryPort {

    private final JpaRaceRepository jpaRaceRepository;

    @Override
    public List<RaceDTO> getAllRace() {
        List<RaceEntity> raceEntities = jpaRaceRepository.findAllByActive(Boolean.TRUE);
        if (raceEntities.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "201-01", HttpStatus.NOT_FOUND);
        return raceEntities
                .stream()
                .map(RaceMapper.INSTANCE::toDomainModel)
                .toList();
    }
}

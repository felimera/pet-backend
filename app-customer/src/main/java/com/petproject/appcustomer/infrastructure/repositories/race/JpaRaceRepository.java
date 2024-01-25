package com.petproject.appcustomer.infrastructure.repositories.race;

import com.petproject.appcustomer.domain.models.in.RaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRaceRepository extends JpaRepository<RaceEntity, Integer> {
    List<RaceEntity> findAllByActive(Boolean active);
}

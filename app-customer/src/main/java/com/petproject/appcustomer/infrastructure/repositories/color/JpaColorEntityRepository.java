package com.petproject.appcustomer.infrastructure.repositories.color;

import com.petproject.appcustomer.domain.models.in.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaColorEntityRepository extends JpaRepository<ColorEntity, Integer> {

    List<ColorEntity> findAllByActive(Boolean active);
}

package com.petproject.appcustomer.infrastructure.repositories.typefigure;

import com.petproject.appcustomer.domain.models.in.TypeFigureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTypeFigureEntityRepository extends JpaRepository<TypeFigureEntity, Integer> {
    @Query("select tf from TypeFigureEntity tf where tf.active =:active")
    List<TypeFigureEntity> getAllTypeFigureByActive(Boolean active);
}

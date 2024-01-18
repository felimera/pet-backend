package com.petproject.appcustomer.infrastructure.repositories.bodysize;

import com.petproject.appcustomer.domain.models.in.BodySizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaBodySizeEntityRepository extends JpaRepository<BodySizeEntity, Integer> {
    @Query("select bs from BodySizeEntity bs  where bs.active = :active")
    List<BodySizeEntity> getAllBodySize(Boolean active);
}

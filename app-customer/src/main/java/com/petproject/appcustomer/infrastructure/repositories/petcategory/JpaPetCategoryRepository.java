package com.petproject.appcustomer.infrastructure.repositories.petcategory;

import com.petproject.appcustomer.domain.models.in.PetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPetCategoryRepository extends JpaRepository<PetCategoryEntity, Integer> {

    List<PetCategoryEntity> findAllByActive(Boolean active);
}

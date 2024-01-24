package com.petproject.appcustomer.infrastructure.repositories.pet;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPetRepository extends JpaRepository<PetEntity,Integer> {
}

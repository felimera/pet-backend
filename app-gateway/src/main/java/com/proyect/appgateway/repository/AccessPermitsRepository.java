package com.proyect.appgateway.repository;

import com.proyect.appgateway.models.AccessPermits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessPermitsRepository extends JpaRepository<AccessPermits, Long>, AccessPermitsCriteriaRepository {
}
package com.proyect.appgateway.repository;

import com.proyect.appgateway.models.AccessPermits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessPermitsRepository extends JpaRepository<AccessPermits, Long>, AccessPermitsCriteriaRepository {
    @Query("select ap from AccessPermits ap inner join ap.user inner join ap.tipoRole tp where tp.acronym =:role ")
    List<AccessPermits> getUserListByRole(String role);
}
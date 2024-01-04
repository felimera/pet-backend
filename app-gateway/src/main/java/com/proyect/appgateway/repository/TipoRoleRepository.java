package com.proyect.appgateway.repository;

import com.proyect.appgateway.models.TipoRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoRoleRepository extends JpaRepository<TipoRole, Long> {

    Optional<TipoRole> findOneByAcronym(String acronym);
}

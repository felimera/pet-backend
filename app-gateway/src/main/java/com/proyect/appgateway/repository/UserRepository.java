package com.proyect.appgateway.repository;

import com.proyect.appgateway.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}

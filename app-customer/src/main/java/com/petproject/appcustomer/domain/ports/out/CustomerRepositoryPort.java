package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    CustomerEntity save(CustomerEntity entity);

    Optional<CustomerEntity> findById(Long id);

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> update(Long id, CustomerEntity entity);

    boolean deleteById(Long id);
}

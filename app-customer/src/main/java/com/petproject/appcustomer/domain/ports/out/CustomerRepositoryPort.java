package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    CustomerEntity save(CustomerEntity entity);

    Optional<CustomerEntity> findById(Integer id);

    List<CustomerEntity> findAll();

    CustomerEntity update(Integer id, CustomerEntity entity);

    boolean deleteById(Integer id);
}

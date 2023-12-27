package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;

import java.util.List;

public interface RetrieveCustomerUseCase {
    CustomerEntity getCustomer(Long id);

    List<CustomerEntity> getAllCustomer();
}

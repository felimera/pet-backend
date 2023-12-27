package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;

public interface UpdateCustomerUseCase {
    CustomerEntity updateCustomer(Long id, CustomerEntity customerEntity);
}

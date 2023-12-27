package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;

public interface CreateCustomerUseCase {
    CustomerEntity createCustomer(CustomerEntity customerEntity);
}

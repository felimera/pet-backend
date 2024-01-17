package com.petproject.appcustomer.domain.ports.in.internal;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;

public interface CreateCustomerUseCase {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
}

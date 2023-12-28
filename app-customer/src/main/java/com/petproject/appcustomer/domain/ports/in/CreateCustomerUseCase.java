package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;

public interface CreateCustomerUseCase {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
}

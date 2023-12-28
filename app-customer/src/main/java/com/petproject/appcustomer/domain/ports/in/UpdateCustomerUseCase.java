package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;

public interface UpdateCustomerUseCase {
    CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO);
}

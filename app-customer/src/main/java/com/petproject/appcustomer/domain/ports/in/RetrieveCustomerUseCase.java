package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;

import java.util.List;

public interface RetrieveCustomerUseCase {
    CustomerDTO getCustomer(Integer id);

    List<CustomerDTO> getAllCustomer();

    CustomerDTO getCustomerByEmailUser(String email);

    CustomerDTO getCustomerByEmail(String email);
}

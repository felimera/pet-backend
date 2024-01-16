package com.petproject.appcustomer.domain.ports.in;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;

import java.util.List;

public interface RetrieveCustomerUseCase {
    CustomerDTO getCustomer(Integer id);

    List<CustomerDTO> getAllCustomer();

    CustomerDTO getCustomerByEmailUser(String email);

    CustomerDTO getCustomerByEmail(String email);

    List<CustomerDTO> getAllCustomerByRole(String role);

    List<CustomerDTO>getMultipleParameter(CustomerSearch customerSearch);
}

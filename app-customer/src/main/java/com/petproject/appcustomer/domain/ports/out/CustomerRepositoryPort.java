package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {
    CustomerDTO save(CustomerDTO dto);

    Optional<CustomerDTO> findById(Integer id);

    List<CustomerDTO> findAll();

    CustomerDTO update(Integer id, CustomerDTO dto);

    boolean deleteById(Integer id);

    CustomerDTO getCustomerByEmailUser(String emailUser);

    CustomerDTO getCustomerByEmail(String email);

    List<CustomerDTO>getAllCustomerByRole(String role);

    List<CustomerDTO>getMultipleParameter(CustomerSearch customerSearch);
}

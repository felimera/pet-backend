package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.CreateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return customerRepositoryPort.save(customerDTO);
    }
}

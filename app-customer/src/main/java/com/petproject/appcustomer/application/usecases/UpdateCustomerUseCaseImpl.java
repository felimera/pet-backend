package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.internal.UpdateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        return customerRepositoryPort.update(id, customerDTO);
    }
}

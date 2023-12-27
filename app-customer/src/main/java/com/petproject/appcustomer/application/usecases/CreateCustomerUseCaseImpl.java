package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.ports.in.CreateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepositoryPort.save(customerEntity);
    }
}

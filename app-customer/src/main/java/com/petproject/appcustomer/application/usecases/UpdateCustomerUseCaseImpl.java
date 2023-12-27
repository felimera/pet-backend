package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.ports.in.UpdateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerEntity updateCustomer(Integer id, CustomerEntity customerEntity) {
        return customerRepositoryPort.update(id, customerEntity);
    }
}

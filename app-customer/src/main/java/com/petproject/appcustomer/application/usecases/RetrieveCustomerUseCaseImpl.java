package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.ports.in.RetrieveCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerEntity getCustomer(Integer id) {
        return customerRepositoryPort.findById(id).orElseThrow();
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepositoryPort.findAll();
    }
}

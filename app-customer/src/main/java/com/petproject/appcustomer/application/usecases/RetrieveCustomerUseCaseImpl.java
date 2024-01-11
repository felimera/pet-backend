package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.RetrieveCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public CustomerDTO getCustomer(Integer id) {
        return customerRepositoryPort.findById(id).orElseThrow();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepositoryPort.findAll();
    }

    @Override
    public CustomerDTO getCustomerByEmailUser(String email) {
        return customerRepositoryPort.getCustomerByEmailUser(email);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return customerRepositoryPort.getCustomerByEmail(email);
    }
}

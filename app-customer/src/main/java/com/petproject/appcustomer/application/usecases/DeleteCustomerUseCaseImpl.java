package com.petproject.appcustomer.application.usecases;

import com.petproject.appcustomer.domain.ports.in.internal.DeleteCustomerUseCase;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final CustomerRepositoryPort customerRepositoryPort;

    @Override
    public boolean deleteCustomer(Integer id) {
        return customerRepositoryPort.deleteById(id);
    }
}

package com.petproject.appcustomer.application.services;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.ports.in.CreateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.DeleteCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.RetrieveCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.UpdateCustomerUseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CreateCustomerUseCase, DeleteCustomerUseCase, RetrieveCustomerUseCase, UpdateCustomerUseCase {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final RetrieveCustomerUseCase retrieveCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @Override
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return createCustomerUseCase.createCustomer(customerEntity);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        return deleteCustomerUseCase.deleteCustomer(id);
    }

    @Override
    public CustomerEntity getCustomer(Integer id) {
        return retrieveCustomerUseCase.getCustomer(id);
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return retrieveCustomerUseCase.getAllCustomer();
    }

    @Override
    public CustomerEntity updateCustomer(Integer id, CustomerEntity customerEntity) {
        return updateCustomerUseCase.updateCustomer(id, customerEntity);
    }
}

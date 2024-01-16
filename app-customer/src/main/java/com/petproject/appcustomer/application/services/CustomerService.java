package com.petproject.appcustomer.application.services;

import com.petproject.appcustomer.domain.ports.in.CreateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.DeleteCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.RetrieveCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.UpdateCustomerUseCase;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerService implements CreateCustomerUseCase, DeleteCustomerUseCase, RetrieveCustomerUseCase, UpdateCustomerUseCase {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final RetrieveCustomerUseCase retrieveCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return createCustomerUseCase.createCustomer(customerDTO);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        return deleteCustomerUseCase.deleteCustomer(id);
    }

    @Override
    public CustomerDTO getCustomer(Integer id) {
        return retrieveCustomerUseCase.getCustomer(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return retrieveCustomerUseCase.getAllCustomer();
    }

    @Override
    public CustomerDTO getCustomerByEmailUser(String email) {
        return retrieveCustomerUseCase.getCustomerByEmailUser(email);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return retrieveCustomerUseCase.getCustomerByEmail(email);
    }

    @Override
    public List<CustomerDTO> getAllCustomerByRole(String role) {
        return retrieveCustomerUseCase.getAllCustomerByRole(role);
    }

    @Override
    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        return updateCustomerUseCase.updateCustomer(id, customerDTO);
    }
}

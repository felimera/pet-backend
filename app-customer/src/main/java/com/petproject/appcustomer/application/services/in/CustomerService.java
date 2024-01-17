package com.petproject.appcustomer.application.services.in;

import com.petproject.appcustomer.domain.ports.in.internal.CreateCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.internal.DeleteCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.internal.RetrieveCustomerUseCase;
import com.petproject.appcustomer.domain.ports.in.internal.UpdateCustomerUseCase;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;
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
    public List<CustomerDTO> getMultipleParameter(CustomerSearch customerSearch) {
        return retrieveCustomerUseCase.getMultipleParameter(customerSearch);
    }

    @Override
    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        return updateCustomerUseCase.updateCustomer(id, customerDTO);
    }
}

package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.CustomerService;
import com.petproject.appcustomer.application.usecases.CreateCustomerUseCaseImpl;
import com.petproject.appcustomer.application.usecases.DeleteCustomerUseCaseImpl;
import com.petproject.appcustomer.application.usecases.RetrieveCustomerUseCaseImpl;
import com.petproject.appcustomer.application.usecases.UpdateCustomerUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.JpaCustomerRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerApplicationConfig {
    @Bean
    public CustomerService customerService(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerService(
                new CreateCustomerUseCaseImpl(customerRepositoryPort),
                new DeleteCustomerUseCaseImpl(customerRepositoryPort),
                new RetrieveCustomerUseCaseImpl(customerRepositoryPort),
                new UpdateCustomerUseCaseImpl(customerRepositoryPort)
        );
    }

    @Bean
    public CustomerRepositoryPort customerRepositoryPort(JpaCustomerRepositoryAdapter jpaCustomerRepositoryAdapter) {
        return jpaCustomerRepositoryAdapter;
    }
}

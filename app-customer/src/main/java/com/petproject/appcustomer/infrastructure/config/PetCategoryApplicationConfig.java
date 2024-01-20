package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.PetCategoryService;
import com.petproject.appcustomer.application.usecases.in.RetrievePetCategoryUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.PetCategoryRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.petcategory.JpaPetCategoryRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetCategoryApplicationConfig {

    @Bean
    public PetCategoryService petCategoryService(PetCategoryRepositoryPort petCategoryRepositoryPort) {
        return new PetCategoryService(
                new RetrievePetCategoryUseCaseImpl(petCategoryRepositoryPort)
        );
    }

    @Bean
    public PetCategoryRepositoryPort petCategoryRepositoryPort(JpaPetCategoryRepositoryAdapter jpaPetCategoryRepositoryAdapter) {
        return jpaPetCategoryRepositoryAdapter;
    }
}

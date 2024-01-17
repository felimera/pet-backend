package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.PetService;
import com.petproject.appcustomer.application.usecases.CreatePetUseCaseImpl;
import com.petproject.appcustomer.application.usecases.DeletePetUseCaseImpl;
import com.petproject.appcustomer.application.usecases.RetrievePetUseCaseImpl;
import com.petproject.appcustomer.application.usecases.UpdatePetUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.JpaPetRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetApplicationConfig {
    @Bean
    public PetService petService(PetRepositoryPort petRepositoryPort) {
        return new PetService(
                new CreatePetUseCaseImpl(petRepositoryPort),
                new DeletePetUseCaseImpl(petRepositoryPort),
                new RetrievePetUseCaseImpl(petRepositoryPort),
                new UpdatePetUseCaseImpl(petRepositoryPort)
        );
    }

    @Bean
    public PetRepositoryPort petRepositoryPort(JpaPetRepositoryAdapter jpaPetRepositoryAdapter) {
        return jpaPetRepositoryAdapter;
    }
}

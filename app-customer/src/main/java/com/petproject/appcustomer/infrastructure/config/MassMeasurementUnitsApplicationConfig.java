package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.MassMeasurementUnitsService;
import com.petproject.appcustomer.application.usecases.in.RetrieveMassMeasurementUnitsUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.MassMeasurementUnitsRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.massunits.JpaMassMeasurementUnitsRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MassMeasurementUnitsApplicationConfig {

    @Bean
    public MassMeasurementUnitsService massMeasurementUnitsService(MassMeasurementUnitsRepositoryPort massMeasurementUnitsRepositoryPort) {
        return new MassMeasurementUnitsService(
                new RetrieveMassMeasurementUnitsUseCaseImpl(massMeasurementUnitsRepositoryPort)
        );
    }

    @Bean
    public MassMeasurementUnitsRepositoryPort massMeasurementUnitsRepositoryPort(JpaMassMeasurementUnitsRepositoryAdapter jpaMassMeasurementUnitsRepositoryAdapter) {
        return jpaMassMeasurementUnitsRepositoryAdapter;
    }
}

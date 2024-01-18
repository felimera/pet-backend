package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.BodySizeService;
import com.petproject.appcustomer.application.usecases.in.RetrieveBodySizeUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.BodySizeRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.bodysize.JpaBodySizeEntityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BodySizeApplicationConfig {

    @Bean
    public BodySizeService bodySizeService(BodySizeRepositoryPort bodySizeRepositoryPort) {
        return new BodySizeService(
                new RetrieveBodySizeUseCaseImpl(bodySizeRepositoryPort)
        );
    }

    @Bean
    public BodySizeRepositoryPort bodySizeRepositoryPort(JpaBodySizeEntityRepositoryAdapter jpaBodySizeEntityRepositoryAdapter) {
        return jpaBodySizeEntityRepositoryAdapter;
    }
}

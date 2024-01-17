package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.ColorService;
import com.petproject.appcustomer.application.usecases.in.RetrieveColorUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.ColorRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.color.JpaColorEntityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColorApplicationConfig {

    @Bean
    public ColorService colorService(ColorRepositoryPort colorRepositoryPort) {
        return new ColorService(
                new RetrieveColorUseCaseImpl(colorRepositoryPort)
        );
    }

    @Bean
    public ColorRepositoryPort colorRepositoryPort(JpaColorEntityRepositoryAdapter jpaColorEntityRepositoryAdapter) {
        return jpaColorEntityRepositoryAdapter;
    }
}

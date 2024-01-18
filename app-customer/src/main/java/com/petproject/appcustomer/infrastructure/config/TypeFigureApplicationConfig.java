package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.TypeFigureService;
import com.petproject.appcustomer.application.usecases.in.RetrieveTypeFigureUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.TypeFigureRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.typefigure.JpaTypeFigureEntityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TypeFigureApplicationConfig {

    @Bean
    public TypeFigureService typeFigureService(TypeFigureRepositoryPort typeFigureRepositoryPort) {
        return new TypeFigureService(
                new RetrieveTypeFigureUseCaseImpl(typeFigureRepositoryPort)
        );
    }

    @Bean
    public TypeFigureRepositoryPort typeFigureRepositoryPort(JpaTypeFigureEntityRepositoryAdapter jpaTypeFigureEntityRepositoryAdapter) {
        return jpaTypeFigureEntityRepositoryAdapter;
    }
}

package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.in.RaceService;
import com.petproject.appcustomer.application.usecases.in.RetrieveRaceUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.RaceRepositoryPort;
import com.petproject.appcustomer.infrastructure.repositories.race.JpaRaceRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RaceApplicationConfig {

    @Bean
    public RaceService raceService(RaceRepositoryPort raceRepositoryPort) {
        return new RaceService(
                new RetrieveRaceUseCaseImpl(raceRepositoryPort)
        );
    }

    @Bean
    public RaceRepositoryPort raceRepositoryPort(JpaRaceRepositoryAdapter jpaRaceRepositoryAdapter) {
        return jpaRaceRepositoryAdapter;
    }
}

package com.petproject.appcustomer.infrastructure.config;

import com.petproject.appcustomer.application.services.external.UserExternalService;
import com.petproject.appcustomer.application.usecases.external.UserGetInfoUseCaseImpl;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import com.petproject.appcustomer.infrastructure.adapters.UserExternalServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserGetInfoApplicationConfig {

    @Bean
    public UserExternalService userExternalService(UserExternalServicePort userExternalServicePort) {
        return new UserExternalService(
                new UserGetInfoUseCaseImpl(userExternalServicePort)
        );
    }

    @Bean
    public UserExternalServicePort externalServicePort() {
        return new UserExternalServiceAdapter();
    }
}

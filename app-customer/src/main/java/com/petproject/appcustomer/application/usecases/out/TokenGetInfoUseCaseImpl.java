package com.petproject.appcustomer.application.usecases.out;

import com.petproject.appcustomer.domain.models.in.TokenEntity;
import com.petproject.appcustomer.domain.ports.in.external.TokenGetInfoUseCase;
import com.petproject.appcustomer.domain.ports.out.TokenExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenGetInfoUseCaseImpl implements TokenGetInfoUseCase {

    private final TokenExternalServicePort externalServicePort;

    @Override
    public TokenEntity getTokenEntity() {
        return externalServicePort.getTokenEntity();
    }
}

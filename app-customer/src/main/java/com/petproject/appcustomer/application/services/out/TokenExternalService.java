package com.petproject.appcustomer.application.services.out;

import com.petproject.appcustomer.domain.models.in.TokenEntity;
import com.petproject.appcustomer.domain.ports.in.external.TokenGetInfoUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenExternalService implements TokenGetInfoUseCase {

    private final TokenGetInfoUseCase tokenGetInfoUseCase;

    @Override
    public TokenEntity getTokenEntity() {
        return tokenGetInfoUseCase.getTokenEntity();
    }
}

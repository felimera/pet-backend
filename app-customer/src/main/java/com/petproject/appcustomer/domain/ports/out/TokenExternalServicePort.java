package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.TokenEntity;

public interface TokenExternalServicePort {

    TokenEntity getTokenEntity();
}

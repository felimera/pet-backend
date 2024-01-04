package com.proyect.appgateway.service;

import com.proyect.appgateway.models.auth.LoginRequest;

public interface LoginService {
    String getTokenGenerator(LoginRequest loginRequest);

    String  getGenerateTokenWithoutAuthorization(LoginRequest loginRequest);
}

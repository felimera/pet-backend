package com.proyect.appgateway.service;

import com.proyect.appgateway.controller.dto.auth.ChangePassowrdDto;
import com.proyect.appgateway.controller.dto.auth.SignUpDto;

public interface AuthService {
    boolean createUser(SignUpDto signUpDto);

    boolean updatePassword(ChangePassowrdDto changePassowrdDto);
}

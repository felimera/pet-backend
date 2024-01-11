package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.UserEntity;

public interface UserExternalServicePort {

    UserEntity getUserByEmail(String email);
}

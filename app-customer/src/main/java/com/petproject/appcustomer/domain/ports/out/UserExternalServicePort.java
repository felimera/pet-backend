package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.in.UserEntity;

import java.util.List;

public interface UserExternalServicePort {

    UserEntity getUserByEmail(String email);

    List<UserEntity> getUserByRole(String role);
}

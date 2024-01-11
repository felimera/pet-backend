package com.petproject.appcustomer.application.services.external;

import com.petproject.appcustomer.domain.models.in.UserEntity;
import com.petproject.appcustomer.domain.ports.in.external.UserGetInfoUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserExternalService implements UserGetInfoUseCase {

    private final UserGetInfoUseCase userGetInfoUseCase;

    @Override
    public UserEntity getCustomerByEmailUser(String emailUser) {
        return userGetInfoUseCase.getCustomerByEmailUser(emailUser);
    }
}

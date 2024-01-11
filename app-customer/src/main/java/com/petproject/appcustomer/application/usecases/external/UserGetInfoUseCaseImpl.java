package com.petproject.appcustomer.application.usecases.external;

import com.petproject.appcustomer.domain.models.in.UserEntity;
import com.petproject.appcustomer.domain.ports.in.external.UserGetInfoUseCase;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserGetInfoUseCaseImpl implements UserGetInfoUseCase {

    private final UserExternalServicePort userExternalServicePort;

    @Override
    public UserEntity getCustomerByEmailUser(String emailUser) {
        return userExternalServicePort.getUserByEmail(emailUser);
    }
}

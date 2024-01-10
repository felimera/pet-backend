package com.petproject.appcustomer.application.services.external;

import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;
import com.petproject.appcustomer.domain.ports.in.external.UserGetInfoUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserExternalService implements UserGetInfoUseCase {

    private final UserGetInfoUseCase userGetInfoUseCase;

    @Override
    public JsonPlaceHolderUser getCustomerByEmailUser(String emailUser) {
        return userGetInfoUseCase.getCustomerByEmailUser(emailUser);
    }
}

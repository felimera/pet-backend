package com.petproject.appcustomer.domain.ports.in.external;

import com.petproject.appcustomer.domain.models.in.UserEntity;

public interface UserGetInfoUseCase {
    UserEntity getCustomerByEmailUser(String emailUser);
}

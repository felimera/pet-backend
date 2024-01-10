package com.petproject.appcustomer.domain.ports.in.external;

import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;

public interface UserGetInfoUseCase {
    JsonPlaceHolderUser getCustomerByEmailUser(String emailUser);
}

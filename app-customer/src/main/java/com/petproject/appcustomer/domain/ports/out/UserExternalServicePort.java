package com.petproject.appcustomer.domain.ports.out;

import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;

public interface UserExternalServicePort {

    JsonPlaceHolderUser getUserByEmail(String email);
}

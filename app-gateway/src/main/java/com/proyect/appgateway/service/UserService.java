package com.proyect.appgateway.service;

import com.proyect.appgateway.models.User;

public interface UserService {
    User putUser(Long id, User user);

    User findById(Long idUser);

    boolean isExistUser(String email);

    User getUserByEmail(String email);
}

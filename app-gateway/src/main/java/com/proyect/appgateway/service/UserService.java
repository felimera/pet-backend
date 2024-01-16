package com.proyect.appgateway.service;

import com.proyect.appgateway.models.User;

import java.util.List;

public interface UserService {
    User putUser(Long id, User user);

    User findById(Long idUser);

    boolean isExistUser(String email);

    User getUserByEmail(String email);

    List<User> getUserListByRole(String role);
}

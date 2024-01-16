package com.proyect.appgateway.service.implementation;


import com.proyect.appgateway.exception.NotFoundException;
import com.proyect.appgateway.models.AccessPermits;
import com.proyect.appgateway.models.User;
import com.proyect.appgateway.repository.AccessPermitsRepository;
import com.proyect.appgateway.repository.UserRepository;
import com.proyect.appgateway.service.UserService;
import com.proyect.appgateway.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AccessPermitsRepository accessPermitsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccessPermitsRepository accessPermitsRepository) {
        this.userRepository = userRepository;
        this.accessPermitsRepository = accessPermitsRepository;
    }

    @Override
    public User putUser(Long id, User user) {
        User entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException(Constants.MESSAGE_USER_NOT_FOUND));
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        return userRepository.save(entity);
    }

    @Override
    public User findById(Long idUser) {
        return userRepository.findById(idUser).orElseThrow(() -> new RuntimeException(Constants.MESSAGE_USER_NOT_FOUND));
    }

    @Override
    public boolean isExistUser(String email) {
        Optional<User> userOptional = userRepository.findOneByEmail(email);
        if (userOptional.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_USER_NOT_FOUND, "415", HttpStatus.NOT_FOUND);
        return true;
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findOneByEmail(email);
        if (userOptional.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_USER_NOT_FOUND, "415", HttpStatus.NOT_FOUND);
        return userOptional.get();
    }

    @Override
    public List<User> getUserListByRole(String role) {
        List<AccessPermits> accessPermitsList = accessPermitsRepository.getUserListByRole(role);
        return accessPermitsList.stream().map(AccessPermits::getUser).distinct().toList();
    }
}

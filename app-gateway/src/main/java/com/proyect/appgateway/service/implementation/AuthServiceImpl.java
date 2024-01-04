package com.proyect.appgateway.service.implementation;

import com.proyect.appgateway.controller.dto.auth.ChangePassowrdDto;
import com.proyect.appgateway.controller.dto.auth.SignUpDto;
import com.proyect.appgateway.controller.mapper.UserMapper;
import com.proyect.appgateway.exception.BusinessException;
import com.proyect.appgateway.exception.NotFoundException;
import com.proyect.appgateway.models.User;
import com.proyect.appgateway.repository.UserRepository;
import com.proyect.appgateway.service.AccessPermitsService;
import com.proyect.appgateway.service.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AccessPermitsService accessPermitsService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AccessPermitsService accessPermitsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accessPermitsService = accessPermitsService;
    }

    @Override
    @Transactional
    public boolean createUser(SignUpDto signUpDto) {

        if (this.isEmailExist(signUpDto.getEmail())) {
            throw new BusinessException("300", HttpStatus.CONFLICT, "This email already exists.");
        }

        String hashPassword = passwordEncoder.encode(signUpDto.getPassword());
        User user = UserMapper.INSTANCE.toSignUp(signUpDto);
        user.setPassword(hashPassword);

        User entity = userRepository.save(user);
        accessPermitsService.postAccessPermits(entity.getId());
        return true;
    }

    @Override
    public boolean updatePassword(ChangePassowrdDto changePassowrdDto) {
        User user = userRepository.findOneByEmail(changePassowrdDto.getEmail()).orElseThrow(() -> new NotFoundException("300", "This email already exists.", HttpStatus.NOT_FOUND));

        if (!passwordEncoder.matches(changePassowrdDto.getPasswordOld(), user.getPassword())) {
            throw new BusinessException("300", HttpStatus.CONFLICT, "Password original es incorrecto.");
        }
        user.setPassword(passwordEncoder.encode(changePassowrdDto.getPasswordNew()));

        User entity = userRepository.save(user);
        return userRepository.existsById(entity.getId());
    }

    private boolean isEmailExist(String email) {
        return userRepository.findOneByEmail(email).isPresent();
    }
}

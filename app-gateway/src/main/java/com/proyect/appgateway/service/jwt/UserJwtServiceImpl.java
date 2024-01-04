package com.proyect.appgateway.service.jwt;

import com.proyect.appgateway.models.User;
import com.proyect.appgateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserJwtServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserJwtServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Write logic to fetch user from DB
        User entity = userRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
        return new org.springframework.security.core.userdetails.User(entity.getEmail(), entity.getPassword(), Collections.emptyList());
    }
}

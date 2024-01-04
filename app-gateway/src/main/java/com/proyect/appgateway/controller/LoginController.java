package com.proyect.appgateway.controller;

import com.proyect.appgateway.models.auth.LoginRequest;
import com.proyect.appgateway.models.auth.LoginResponse;
import com.proyect.appgateway.service.LoginService;
import com.proyect.appgateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private UserService userService;

    private LoginService loginService;

    @Autowired
    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        userService.isExistUser(loginRequest.getEmail());
        String jwt = loginService.getTokenGenerator(loginRequest);
        // Aditional logic can here be added here if needed.
        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}

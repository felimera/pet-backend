package com.proyect.appgateway.controller;

import com.proyect.appgateway.controller.dto.MessageDto;
import com.proyect.appgateway.controller.dto.auth.ChangePassowrdDto;
import com.proyect.appgateway.controller.dto.auth.SignUpDto;
import com.proyect.appgateway.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/signup")
public class SignupController {

    private AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<Object> signUser(@RequestBody SignUpDto signUpDto) {
        boolean isUserCreated = authService.createUser(signUpDto);
        if (isUserCreated)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(MessageDto.builder().code(String.valueOf(HttpStatus.CREATED.value())).message("User created succesfully.").build());
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MessageDto.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message("Failed created user.").build());
    }

    @PutMapping
    public ResponseEntity<Object> updatePassword(@RequestBody ChangePassowrdDto changePassowrdDto) {
        boolean isUser = authService.updatePassword(changePassowrdDto);
        if (isUser)
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(MessageDto.builder().code(String.valueOf(HttpStatus.CREATED.value())).message("User edit  succesfully.").build());
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MessageDto.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value())).message("Failed edit user.").build());
    }
}

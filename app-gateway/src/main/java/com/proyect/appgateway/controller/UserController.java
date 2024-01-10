package com.proyect.appgateway.controller;

import com.proyect.appgateway.controller.mapper.UserMapper;
import com.proyect.appgateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUserByEmail(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(UserMapper.INSTANCE.toDto(userService.getUserByEmail(email)));
    }
}

package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}

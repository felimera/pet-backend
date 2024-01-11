package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.CustomerService;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.exception.ResponseMessageException;
import com.petproject.appcustomer.infrastructure.util.CadenaUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        log.info("Creating Customer : {}", customerDTO);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerDTO));
    }

    @GetMapping(path = "/user")
    public ResponseEntity<Object> getCustomerByEmailUser(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(customerService.getCustomerByEmailUser(email));
    }

    @GetMapping
    public ResponseEntity<Object> getCustomerByEmail(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }
}

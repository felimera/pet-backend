package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.in.CustomerService;
import com.petproject.appcustomer.domain.models.in.enums.Role;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;
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
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(path = "/information")
    public ResponseEntity<Object> getCustomerByEmail(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email));
    }

    @GetMapping(path = "/filterrole")
    public ResponseEntity<Object> getAllCustomerByRole(@RequestParam(name = "role") String role) {
        return ResponseEntity.ok(customerService.getAllCustomerByRole(role));
    }

    @GetMapping(path = "/searchparameter")
    public ResponseEntity<Object> getMultipleParameter(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam(name = "lastName", required = false) String lastName,
            @RequestParam(name = "phone", required = false) String phone,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "role") String role
    ) {
        log.info("Search FirstName : {}", firstName);
        log.info("Search LastName : {}", lastName);
        log.info("Search Phone : {}", phone);
        log.info("Search Email : {}", email);
        log.info("Search Role : {}", role);
        CustomerSearch customerSearch = CustomerSearch
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .role(Role.getName(role))
                .build();
        return ResponseEntity.ok(customerService.getMultipleParameter(customerSearch));
    }
}

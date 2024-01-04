package com.proyect.appgateway.controller;

import com.proyect.appgateway.service.AccessPermitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/accesspermits")
public class AccessPermitsController {

    private AccessPermitsService accessPermitsService;

    @Autowired
    public AccessPermitsController(AccessPermitsService accessPermitsService) {
        this.accessPermitsService = accessPermitsService;
    }

    @GetMapping(path = "/link")
    public ResponseEntity<Object> getAccessPermitsByIdCustomer(@RequestParam(name = "email") String email) {
        return ResponseEntity.ok(accessPermitsService.getAccessPermitsByEmailUser(email));
    }
}

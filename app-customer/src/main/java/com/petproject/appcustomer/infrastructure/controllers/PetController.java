package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/pet")
@AllArgsConstructor
public class PetController {

    private PetService petService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(petService.getAllPet());
    }
}

package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.in.ColorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/color")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ColorController {

    private ColorService colorService;

    @GetMapping
    public ResponseEntity<Object> getAllColor() {
        return ResponseEntity.ok(colorService.getAllColor());
    }
}

package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.in.MassMeasurementUnitsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/massunits")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class MassMeasurementUnitsController {

    private MassMeasurementUnitsService massMeasurementUnitsService;

    @GetMapping
    public ResponseEntity<Object> getAllMassMeasurementUnitsByActive() {
        return ResponseEntity.ok(massMeasurementUnitsService.getAllMassMeasurementUnits());
    }
}

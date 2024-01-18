package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.in.TypeFigureService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/typefigure")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class TypeFigureController {

    private TypeFigureService typeFigureService;

    @GetMapping
    public ResponseEntity<Object> getAllTypeFigure() {
        return ResponseEntity.ok(typeFigureService.getAllTypeFigure());
    }
}

package com.petproject.appcustomer.infrastructure.controllers;

import com.petproject.appcustomer.application.services.in.PetService;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;
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
@RequestMapping(path = "api/pet")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PetController {

    private PetService petService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(petService.getAllPet());
    }

    @PostMapping
    public ResponseEntity<Object> createPet(@Valid @RequestBody PetDTO petDTO, BindingResult bindingResult) {
        log.info("Creating Pet : {}", petDTO);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.createCustomer(petDTO));
    }

    @GetMapping(path = "/multi")
    public ResponseEntity<Object> getPetMultipleParameter(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "nameOwner", required = false) String nameOwner,
            @RequestParam(name = "idRaceEntity", required = false) Integer idRaceEntity
    ) {
        PetSearch petSearch = PetSearch
                .builder()
                .namePet(name)
                .nameOwner(nameOwner)
                .idRaceEntity(idRaceEntity)
                .build();
        return ResponseEntity.ok(petService.getPetMultipleParameter(petSearch));
    }
}

package com.project.appmedia.controller;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import com.project.appmedia.exception.ResponseMessageException;
import com.project.appmedia.mapper.PhotoPetMapper;
import com.project.appmedia.models.PhotoPet;
import com.project.appmedia.service.PhotoPetService;
import com.project.appmedia.util.CadenaUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/photo")
@Slf4j
public class PhotoPetController {

    private PhotoPetService photoPetService;

    @Autowired
    public PhotoPetController(PhotoPetService photoPetService) {
        this.photoPetService = photoPetService;
    }

    @GetMapping(path = "/pet/{idPet}")
    public ResponseEntity<Object> getAllPet(@PathVariable(name = "idPet") String idPet) {
        log.info("Search PhotoPet by  idPet : {}", idPet);
        return ResponseEntity.ok(photoPetService.getAllByIdPet(Integer.parseInt(idPet)));
    }

    @PostMapping
    public ResponseEntity<Object> createOnePhoto(@Valid @RequestBody PhotoPetDTO petDTO, BindingResult bindingResult) {
        log.info("Creating PhotoPet : {}", petDTO);
        if (bindingResult.hasErrors())
            throw new ResponseMessageException("401-01", "Error creating client.", CadenaUtil.formatMessage(bindingResult), HttpStatus.BAD_REQUEST);
        PhotoPet photoPet = PhotoPetMapper.INSTANCE.fromDomainModel(petDTO);
        String[] location = photoPet.getLocation().split("/");
        int tamanoLocation = location.length;
        String[] extension = photoPet.getLocation().split("\\.");

        photoPet.setName(location[--tamanoLocation]);
        photoPet.setExtension(extension[1]);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(PhotoPetMapper.INSTANCE.toDomainModel(photoPetService.createOnePhotoPet(photoPet)));
    }
}

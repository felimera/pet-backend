package com.project.appmedia.controller;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import com.project.appmedia.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping(value = "api/media")
@AllArgsConstructor
public class MediaController {

    private final StorageService storageService;
    private final HttpServletRequest request;

    @PostMapping(path = "/upload/{idPet}")
    public ResponseEntity<Map<String, String>> uploadFile(
            @RequestParam(name = "file") MultipartFile multipartFile,
            @PathVariable(name = "idPet") String idPet) {
        String path = storageService.store(multipartFile, Integer.parseInt(idPet));
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/api/media/")
                .path(path)
                .toUriString();

        return ResponseEntity.ok(Map.of("url", url));
    }

    @PostMapping(path = "upload/list")
    public ResponseEntity<Object> uploadFileList(@RequestBody PhotoPetDTO dto) {
        storageService.storeList(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
}

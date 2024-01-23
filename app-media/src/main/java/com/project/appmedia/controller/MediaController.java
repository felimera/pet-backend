package com.project.appmedia.controller;

import com.project.appmedia.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
@Slf4j
public class MediaController {

    private final StorageService storageService;
    private final HttpServletRequest request;

    @PostMapping(path = "/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam(name = "file") MultipartFile multipartFile) {
        log.info("Add Photo : {}", multipartFile);
        String path = storageService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder
                .fromHttpUrl(host)
                .path("/api/media/")
                .path(path)
                .toUriString();

        return ResponseEntity.ok(Map.of("url", url));
    }

    @GetMapping(path = "{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
        log.info("Search  Photo by  filename : {}", filename);
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
}

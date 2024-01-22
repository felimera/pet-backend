package com.project.appmedia.service;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    void init() throws IOException;

    String store(MultipartFile file, Integer idPet);

    Resource loadAsResource(String filename);

    void storeList(PhotoPetDTO dto);
}

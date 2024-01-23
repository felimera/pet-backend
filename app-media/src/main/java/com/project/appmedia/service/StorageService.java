package com.project.appmedia.service;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StorageService {

    void init() throws IOException;

    String store(MultipartFile file, Integer idPet);

    Resource loadAsResource(String filename);

    void storeList(PhotoPetDTO dto);

    List<PhotoPetDTO> getPhotoPetDtoListByPetId(Integer idPet);
}

package com.project.appmedia.service;

import com.project.appmedia.models.PhotoPet;

import java.nio.file.Path;
import java.util.List;

public interface PhotoPetService {
    PhotoPet createOnePhotoPet(String filename, Path path, Integer idPet);

    List<PhotoPet> getAllByIdPet(Integer idPet);
}

package com.project.appmedia.service;

import com.project.appmedia.models.PhotoPet;

import java.nio.file.Path;

public interface PhotoPetService {
    PhotoPet createOnePhotoPet(String filename, Path path, Integer idPet);
}

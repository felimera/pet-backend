package com.project.appmedia.service;

import com.project.appmedia.models.PhotoPet;

import java.util.List;

public interface PhotoPetService {
    PhotoPet createOnePhotoPet(PhotoPet photoPet);

    List<PhotoPet> getAllByIdPet(Integer idPet);
}

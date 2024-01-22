package com.project.appmedia.service.implementation;

import com.project.appmedia.PhotoPetRepository;
import com.project.appmedia.models.PhotoPet;
import com.project.appmedia.service.PhotoPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class PhotoPetServiceImpl implements PhotoPetService {

    private PhotoPetRepository photoPetRepository;

    @Autowired
    public PhotoPetServiceImpl(PhotoPetRepository photoPetRepository) {
        this.photoPetRepository = photoPetRepository;
    }

    @Override
    public PhotoPet createOnePhotoPet(String filename, Path path) {
        String location = path.toAbsolutePath().toString().replaceAll(filename, "");
        String[] extension = filename.split("\\.");
        PhotoPet photoPetNew = new PhotoPet();
        photoPetNew.setName(filename);
        photoPetNew.setExtension(extension[1]);
        photoPetNew.setLocation(location);
        photoPetNew.setProfilePicture(Boolean.FALSE);

        return photoPetRepository.save(photoPetNew);
    }
}

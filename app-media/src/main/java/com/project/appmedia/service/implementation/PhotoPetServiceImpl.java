package com.project.appmedia.service.implementation;

import com.project.appmedia.exception.BusinessException;
import com.project.appmedia.exception.NotFoundException;
import com.project.appmedia.models.PhotoPet;
import com.project.appmedia.repository.PhotoPetRepository;
import com.project.appmedia.service.PhotoPetService;
import com.project.appmedia.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoPetServiceImpl implements PhotoPetService {

    private PhotoPetRepository photoPetRepository;

    @Autowired
    public PhotoPetServiceImpl(PhotoPetRepository photoPetRepository) {
        this.photoPetRepository = photoPetRepository;
    }

    @Override
    public PhotoPet createOnePhotoPet(PhotoPet photoPet) {

        if (photoPetRepository.existsByName(photoPet.getName()))
            throw new BusinessException("404-01", HttpStatus.CONFLICT, Constants.MESSAGE_NOT_EXIST_DATA);
        return photoPetRepository.save(photoPet);
    }

    @Override
    public List<PhotoPet> getAllByIdPet(Integer idPet) {
        List<PhotoPet> photoPets = photoPetRepository.findAllByPetId(idPet);
        if (photoPets.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "405-01", HttpStatus.NOT_FOUND);
        return photoPets;
    }
}

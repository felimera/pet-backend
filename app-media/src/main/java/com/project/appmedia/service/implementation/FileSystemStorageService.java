package com.project.appmedia.service.implementation;

import com.project.appmedia.controller.dto.PhotoPetDTO;
import com.project.appmedia.exception.NotFoundException;
import com.project.appmedia.exception.RequestException;
import com.project.appmedia.mapper.PhotoPetMapper;
import com.project.appmedia.models.PhotoPet;
import com.project.appmedia.service.PhotoPetService;
import com.project.appmedia.service.StorageService;
import com.project.appmedia.util.Constants;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileSystemStorageService implements StorageService {

    @Value("${media.location}")
    private String mediaLocation;
    private Path rootLocation;

    private PhotoPetService photoPetService;

    @Autowired
    public FileSystemStorageService(PhotoPetService photoPetService) {
        this.photoPetService = photoPetService;
    }

    @Override
    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(mediaLocation);
        Files.createDirectories(rootLocation);
    }

    @Override
    @Transactional
    public String store(MultipartFile file, Integer idPet) {
        try {
            if (file.isEmpty())
                throw new RequestException(Constants.CODE_404_02, "Failed to store empty file.");

            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation
                    .resolve(Paths.get(filename))
                    .normalize()
                    .toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            photoPetService.createOnePhotoPet(filename, destinationFile, idPet);

            return filename;
        } catch (IOException e) {
            throw new RequestException(Constants.CODE_404_02, "Failed to store file." + e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource((file.toUri()));

            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new NotFoundException("Could not read file : " + filename, "404-01", HttpStatus.NOT_FOUND);
        } catch (MalformedURLException e) {
            throw new RequestException(Constants.CODE_404_02, "Could not read file : " + filename);
        }
    }

    @Override
    public void storeList(PhotoPetDTO dto) {
        dto.getMultipartFileList().forEach(multipartFile -> store(multipartFile, dto.getPetId()));
    }

    @Override
    public List<PhotoPetDTO> getPhotoPetDtoListByPetId(Integer idPet) {
        List<PhotoPet> photoPets = photoPetService.getAllByIdPet(idPet);
        if (photoPets.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "404-01", HttpStatus.NOT_FOUND);
        return photoPets.stream().map(PhotoPetMapper.INSTANCE::toDomainModel).toList();
    }
}

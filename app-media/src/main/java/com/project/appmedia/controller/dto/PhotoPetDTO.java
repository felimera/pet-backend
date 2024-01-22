package com.project.appmedia.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class PhotoPetDTO {
    private Integer id;
    private List<MultipartFile> multipartFileList;
    private Integer idPet;
}

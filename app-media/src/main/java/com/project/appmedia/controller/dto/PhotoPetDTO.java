package com.project.appmedia.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoPetDTO {
    private Integer id;
    private String name;
    private String extension;
    private String location;
    private Boolean profilePicture;
    private String comment;
    private Integer petId;

    private List<MultipartFile> multipartFileList;
}

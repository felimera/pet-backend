package com.project.appmedia.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoPetDTO {
    private Integer id;
    @Size(max = 50, message = "The photo name has a maximum of 50 characters.")
    private String name;
    @Size(max = 5, message = "The photo extension has a maximum of 5 characters.")
    private String extension;
    @NotEmpty(message = "The photo location cannot be empty.")
    @NotNull(message = "The photo location cannot be null.")
    @Size(max = 500, message = "The photo location has a maximum of 500 characters.")
    private String location;
    private Boolean profilePicture;
    @Size(max = 1000, message = "The photo comment has a maximum of 1000 characters.")
    private String comment;
    private Integer petId;
}

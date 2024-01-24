package com.project.appmedia.models;

import com.project.appmedia.util.config.BooleanConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_photo_pet")
public class PhotoPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pp_id")
    private Integer id;
    @Column(name = "pp_name")
    private String name;
    @Column(name = "pp_extension")
    private String extension;
    @Column(name = "pp_location")
    private String location;
    @Column(name = "pp_profile_picture")
    @Convert(converter = BooleanConverter.class)
    private Boolean profilePicture;
    @Column(name = "pp_comment")
    private String comment;
    @Column(name = "pp_pet_id")
    private Integer petId;
    @Column(name = "pp_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "pp_modification_date")
    private LocalDateTime modificationDate;
}

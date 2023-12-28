package com.petproject.appcustomer.infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private Integer id;
    private String name;
    private String photo;
    private String birthdate;
    private String age;
    private String gender;
    private String petCategory;
    private String race;
    private String weight;
    private String characteristicsExtremities;

    private Integer idCustomerEntity;
    private Integer idHairColorEntity;
    private Integer idBodySizeEntity;
    private Integer idTypeFigureEntity;
    private Integer idEyeColorEntity;
}

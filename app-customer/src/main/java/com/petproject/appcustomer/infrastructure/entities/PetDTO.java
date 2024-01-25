package com.petproject.appcustomer.infrastructure.entities;

import com.petproject.appcustomer.infrastructure.util.Constants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "The pet's name cannot be empty.")
    @NotNull(message = "The pet's name cannot be null.")
    @Size(max = 50, message = "The pet's name only has a maximum of 50 characters.")
    @Pattern(regexp = "^[ a-zA-ZñÑáéíóúÁÉÍÓÚ]+$", message = "It is not a valid name.")
    private String name;
    @Size(max = 1000, message = "The pet's photo only has a maximum of 1000 characters.")
    private String photo;
    @Pattern(regexp = Constants.REGULARPHRASE_BIRTHDATE, message = "Incorrect date format. Ex: yyyy-MM-dd.")
    private String birthdate;
    private String age;
    @NotEmpty(message = "The pet's gender cannot be empty.")
    @NotNull(message = "The pet's gender cannot be null.")
    @Size(min = 1, max = 1, message = "The pet's gender only has a maximum of 1 characters.")
    private String gender;
    @NotEmpty(message = "The pet's weight cannot be empty.")
    @NotNull(message = "The pet's weight cannot be null.")
    private String characteristicsExtremities;

    @NotNull(message = "The pet's Customer cannot be null.")
    private Integer idCustomerEntity;
    @NotEmpty(message = "The pet's weight cannot be empty.")
    @NotNull(message = "The pet's weight cannot be null.")
    private String weightValue;
    @NotNull(message = "The pet's weight units cannot be null.")
    private Integer idMassMeasurementUnitsEntity;
    @NotNull(message = "The pet's Hair Color cannot be null.")
    private Integer idHairColorEntity;
    @NotNull(message = "The pet's Type Figure cannot be null.")
    private Integer idTypeFigureEntity;
    @NotNull(message = "The pet's Eye Color cannot be null.")
    private Integer idEyeColorEntity;
    @NotNull(message = "The pet race cannot be null.")
    private Integer idRaceEntity;
}

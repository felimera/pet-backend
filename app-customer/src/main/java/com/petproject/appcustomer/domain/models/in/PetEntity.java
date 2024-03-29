package com.petproject.appcustomer.domain.models.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.petproject.appcustomer.domain.models.in.enums.Gender;
import com.petproject.appcustomer.infrastructure.util.config.GenderConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pe_id")
    private Integer id;
    @Column(name = "pe_name")
    private String name;
    @Column(name = "pe_photo")
    private String photo;
    @Column(name = "pe_birthdate")
    private LocalDate birthdate;
    @Column(name = "pe_age")
    private String age;
    @Column(name = "pe_gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    @Column(name = "pe_characteristics_extremities")
    private String characteristicsExtremities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CustomerEntity customerEntity;
    @Column(name = "pe_weight_value")
    private String weightValue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_weight_mmu_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MassMeasurementUnitsEntity massMeasurementUnitsEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_hair_color_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ColorEntity hairColorEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_type_figure_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeFigureEntity typeFigureEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_eye_color_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ColorEntity eyeColorEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_race_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RaceEntity raceEntity;

    @Column(name = "pe_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "pe_modification_date")
    private LocalDateTime modificationDate;
}

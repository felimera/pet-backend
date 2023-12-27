package com.petproject.appcustomer.domain.models.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pe_id")
    private Integer id;
    @Column(name = "pe_name")
    private String name;
    @Column(name = "pe_phone")
    private String phone;
    @Column(name = "pe_birthdate")
    private LocalDate birthdate;
    @Column(name = "pe_age")
    private String age;
    @Column(name = "pe_gender")
    private String gender;
    @Column(name = "pe_pet_category")
    private String petCategory;
    @Column(name = "pe_race")
    private String race;
    @Column(name = "pe_weight")
    private String weight;
    @Column(name = "pe_characteristics_extremities")
    private String characteristicsExtremities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CustomerEntity customerEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_hair_color_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ColorEntity hairColorEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_body_size_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BodySizeEntity bodySizeEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_type_figure_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeFigureEntity typeFigureEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pe_eye_color_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ColorEntity eyeColorEntity;
}

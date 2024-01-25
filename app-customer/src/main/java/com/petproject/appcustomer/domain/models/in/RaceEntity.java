package com.petproject.appcustomer.domain.models.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.petproject.appcustomer.infrastructure.util.config.BooleanConverter;
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
@Table(name = "tbl_race")
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rac_id")
    private Integer id;
    @Column(name = "rac_name")
    private String name;
    @Column(name = "rac_description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rac_body_size_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BodySizeEntity bodySizeEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rac_pet_category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PetCategoryEntity petCategoryEntity;
    @Column(name = "rac_active")
    @Convert(converter = BooleanConverter.class)
    private Boolean active;
    @Column(name = "pe_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "pe_modification_date")
    private LocalDateTime modificationDate;
}

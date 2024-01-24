package com.petproject.appcustomer.domain.models.in;

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
@Table(name = "tbl_mass_measurement_units")
public class MassMeasurementUnitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mmu_id")
    private Integer id;
    @Column(name = "mmu_name")
    private String name;
    @Column(name = "mmu_acronym")
    private String acronym;
    @Column(name = "mmu_description")
    private String description;
    @Column(name = "mmu_active")
    @Convert(converter = BooleanConverter.class)
    private Boolean active;
    @Column(name = "mmu_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "mmu_modification_date")
    private LocalDateTime modificationDate;
}

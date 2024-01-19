package com.petproject.appcustomer.domain.models.in;

import com.petproject.appcustomer.infrastructure.util.config.BooleanConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_pet_category")
public class PetCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pc_id")
    private Integer id;
    @Column(name = "pc_name")
    private String name;
    @Column(name = "pc_description")
    private String description;
    @Column(name = "pc_active")
    @Convert(converter = BooleanConverter.class)
    private Boolean active;
}

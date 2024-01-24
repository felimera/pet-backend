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
@Table(name = "tbl_body_size")
public class BodySizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bs_id")
    private Integer id;
    @Column(name = "bs_name")
    private String name;
    @Column(name = "bs_description")
    private String description;
    @Column(name = "bs_active")
    @Convert(converter = BooleanConverter.class)
    private Boolean active;
    @Column(name = "bs_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "bs_modification_date")
    private LocalDateTime modificationDate;
}

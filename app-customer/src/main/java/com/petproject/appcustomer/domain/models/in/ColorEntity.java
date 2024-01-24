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
@Table(name = "tbl_color")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "col_id")
    private Integer id;
    @Column(name = "col_name")
    private String name;
    @Column(name = "col_code")
    private String code;
    @Column(name = "col_active")
    @Convert(converter = BooleanConverter.class)
    private Boolean active;
    @Column(name = "col_creation_date")
    private LocalDateTime creationDate;
    @Column(name = "col_modification_date")
    private LocalDateTime modificationDate;
}

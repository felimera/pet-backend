package com.petproject.appcustomer.domain.models.in;

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
@Table(name = "tbl_type_figure")
public class TypeFigureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tf_id")
    private Integer id;
    @Column(name = "tf_name")
    private String name;
    @Column(name = "tf_description")
    private String description;
}

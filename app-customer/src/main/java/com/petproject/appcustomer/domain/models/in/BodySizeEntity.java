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
}

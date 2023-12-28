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
@Table(name = "tbl_customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private Integer id;
    @Column(name = "cus_first_name")
    private String firstName;
    @Column(name = "cus_last_name")
    private String lastName;
    @Column(name = "cus_home_address")
    private String homeAddress;
    @Column(name = "cus_phone")
    private String phone;
    @Column(name = "cus_email")
    private String email;
    @Column(name = "cus_is_older")
    private Boolean isOlder;
    @Column(name = "cus_user_id")
    private Integer userId;
}

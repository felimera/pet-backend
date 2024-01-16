package com.petproject.appcustomer.infrastructure.entities.search;

import com.petproject.appcustomer.domain.models.in.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CustomerSearch {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private List<Integer> ids;
}

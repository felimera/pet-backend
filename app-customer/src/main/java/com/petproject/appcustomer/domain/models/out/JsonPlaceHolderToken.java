package com.petproject.appcustomer.domain.models.out;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class JsonPlaceHolderToken {
    private String email;
    private String password;
    private String jwtToken;
}

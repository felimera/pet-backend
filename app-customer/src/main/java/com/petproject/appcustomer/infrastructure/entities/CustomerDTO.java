package com.petproject.appcustomer.infrastructure.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Integer id;
    @NotEmpty(message = "The customer's first name cannot be empty.")
    @NotNull(message = "The customer's first name cannot be null.")
    @Size(max = 50, message = "The customer's name only has a maximum of 50 characters.")
    @Pattern(regexp = "^[ a-zA-ZñÑáéíóúÁÉÍÓÚ]+$",message = "It is not a valid name.")
    private String firstName;
    @NotEmpty(message = "The customer's last name cannot be empty.")
    @NotNull(message = "The customer's last name cannot be null.")
    @Size(max = 50, message = "The customer's last name only has a maximum of 50 characters.")
    @Pattern(regexp = "^[ a-zA-ZñÑáéíóúÁÉÍÓÚ]+$",message = "It is not a valid last name.")
    private String lastName;
    @NotEmpty(message = "The customer's address cannot be empty.")
    @Size(max = 100, message = "The customer's home address only has a maximum of 100 characters.")
    private String homeAddress;
    @NotEmpty(message = "The customer's last name cannot be empty.")
    @NotNull(message = "The customer's last name cannot be null.")
    @Size(max = 10, message = "The customer's phone only has a maximum of 10 characters.")
    @Pattern(regexp = "^[0-9,$]*$", message = "It is not a valid number.")
    private String phone;
    @NotEmpty(message = "The customer's email cannot be empty.")
    @Email(message = "The email is not formatted correctly.")
    @Size(max = 50, message = "The customer's email only has a maximum of 50 characters.")
    private String email;
    @NotNull(message = "The customer's 'is Older' cannot be null.")
    private Boolean isOlder;
    private Integer userId;
}

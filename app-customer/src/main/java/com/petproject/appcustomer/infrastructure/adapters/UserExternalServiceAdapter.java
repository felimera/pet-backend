package com.petproject.appcustomer.infrastructure.adapters;

import com.petproject.appcustomer.domain.models.in.UserEntity;
import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class UserExternalServiceAdapter implements UserExternalServicePort {

    private final RestTemplate restTemplate;

    public UserExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        String apiUrl = "http://localhost:8080/api/user?email=" + email;
        ResponseEntity<JsonPlaceHolderUser> responseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser jsonPlaceHolderUser = responseEntity.getBody();
        if (Objects.isNull(jsonPlaceHolderUser))
            return null;
        return new UserEntity(jsonPlaceHolderUser.getId(),jsonPlaceHolderUser.getName(),jsonPlaceHolderUser.getEmail());
    }
}

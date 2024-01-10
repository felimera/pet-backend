package com.petproject.appcustomer.infrastructure.adapters;

import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@AllArgsConstructor
public class UserExternalServiceAdapter implements UserExternalServicePort {

    private final RestTemplate restTemplate;

    @Override
    public JsonPlaceHolderUser getUserByEmail(String email) {
        String apiUrl = "http://localhost:8080/api/user?email=" + email;
        ResponseEntity<JsonPlaceHolderUser> responseEntity = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser jsonPlaceHolderUser = responseEntity.getBody();
        if (Objects.isNull(jsonPlaceHolderUser))
            return null;
        return jsonPlaceHolderUser;
    }
}

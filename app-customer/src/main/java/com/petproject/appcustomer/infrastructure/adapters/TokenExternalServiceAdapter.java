package com.petproject.appcustomer.infrastructure.adapters;

import com.petproject.appcustomer.domain.models.in.TokenEntity;
import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderToken;
import com.petproject.appcustomer.domain.ports.out.TokenExternalServicePort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class TokenExternalServiceAdapter implements TokenExternalServicePort {

    private final RestTemplate restTemplate;

    public TokenExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public TokenEntity getTokenEntity() {
        String apiUrl = "http://localhost:8080/login";
        JsonPlaceHolderToken registreUser = JsonPlaceHolderToken.builder().email("system.registry@system.com").password("password").build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "application/json;charset=UTF-8");
        HttpEntity<JsonPlaceHolderToken> request = new HttpEntity<>(registreUser, headers);

        ResponseEntity<JsonPlaceHolderToken> responseEntity = restTemplate.postForEntity(apiUrl, request, JsonPlaceHolderToken.class);
        JsonPlaceHolderToken jsonPlaceHolderToken = responseEntity.getBody();
        if (Objects.isNull(jsonPlaceHolderToken))
            return null;
        return new TokenEntity(jsonPlaceHolderToken.getJwtToken());
    }
}

package com.petproject.appcustomer.infrastructure.adapters;

import com.petproject.appcustomer.domain.models.in.TokenEntity;
import com.petproject.appcustomer.domain.models.in.UserEntity;
import com.petproject.appcustomer.domain.models.out.JsonPlaceHolderUser;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import com.petproject.appcustomer.infrastructure.exception.RequestException;
import com.petproject.appcustomer.infrastructure.util.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UserExternalServiceAdapter extends TokenExternalServiceAdapter implements UserExternalServicePort {

    private final RestTemplate restTemplate;
    @Value("${variable.config.gateway.url}")
    private String gatewayUrl;

    public UserExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        String apiUrl = gatewayUrl + "api/user?email=" + email;
        ResponseEntity<JsonPlaceHolderUser> responseEntity;
        TokenEntity tokenEntity = getTokenEntity();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenEntity.getJwtToken());
        try {
            responseEntity = restTemplate.exchange(RequestEntity.get(new URI(apiUrl)).headers(headers).build(), JsonPlaceHolderUser.class);
        } catch (URISyntaxException e) {
            throw new RequestException("403-32", Constants.MESSAGE_NOT_FOUND + e.getMessage());
        }

        JsonPlaceHolderUser jsonPlaceHolderUser = responseEntity.getBody();
        if (Objects.isNull(jsonPlaceHolderUser))
            return null;
        return new UserEntity(jsonPlaceHolderUser.getId(), jsonPlaceHolderUser.getName(), jsonPlaceHolderUser.getEmail());
    }

    @Override
    public List<UserEntity> getUserByRole(String role) {
        String apiUrl = gatewayUrl + "api/user/filterrole?role=" + role;
        ResponseEntity<JsonPlaceHolderUser[]> responseEntity;
        TokenEntity tokenEntity = getTokenEntity();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenEntity.getJwtToken());
        try {
            responseEntity = restTemplate.exchange(RequestEntity.get(new URI(apiUrl)).headers(headers).build(), JsonPlaceHolderUser[].class);
        } catch (URISyntaxException e) {
            throw new RequestException("403-32", Constants.MESSAGE_NOT_FOUND + e.getMessage());
        }

        JsonPlaceHolderUser[] holderUsers = responseEntity.getBody();
        if (Objects.isNull(holderUsers))
            return Collections.emptyList();
        List<UserEntity> userEntityList = new ArrayList<>();
        for (JsonPlaceHolderUser userjson : holderUsers) {
            userEntityList.add(new UserEntity(userjson.getId(), userjson.getName(), userjson.getEmail()));
        }
        return userEntityList;
    }
}

package com.proyect.appgateway.service;
import com.proyect.appgateway.controller.dto.AccessPermitsDto;
import org.springframework.stereotype.Service;

@Service
public interface AccessPermitsService {
    void postAccessPermits(Long idUser);

    AccessPermitsDto getAccessPermitsByEmailUser(String email);
}

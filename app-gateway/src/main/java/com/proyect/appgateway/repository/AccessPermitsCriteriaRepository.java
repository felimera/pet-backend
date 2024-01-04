package com.proyect.appgateway.repository;


import com.proyect.appgateway.models.AccessPermits;

import java.util.List;

public interface AccessPermitsCriteriaRepository {
    List<AccessPermits> getAccessPermitsByEmailUser(String email);
}
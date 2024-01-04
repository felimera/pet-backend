package com.proyect.appgateway.service;

import com.proyect.appgateway.models.TipoRole;

public interface TipoRoleService {
    TipoRole getTipoRoleByAcronym(String acronym);
}
package com.proyect.appgateway.service.implementation;
import com.proyect.appgateway.exception.NotFoundException;
import com.proyect.appgateway.models.TipoRole;
import com.proyect.appgateway.repository.TipoRoleRepository;
import com.proyect.appgateway.service.TipoRoleService;
import com.proyect.appgateway.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TipoRoleServiceImpl implements TipoRoleService {

    private TipoRoleRepository tipoRoleRepository;

    @Autowired
    public TipoRoleServiceImpl(TipoRoleRepository tipoRoleRepository) {
        this.tipoRoleRepository = tipoRoleRepository;
    }

    @Override
    public TipoRole getTipoRoleByAcronym(String acronym) {
        return tipoRoleRepository.findOneByAcronym(acronym).orElseThrow(() -> new NotFoundException(Constants.MESSAGE_NOT_FOUND, "601", HttpStatus.NOT_FOUND));
    }
}

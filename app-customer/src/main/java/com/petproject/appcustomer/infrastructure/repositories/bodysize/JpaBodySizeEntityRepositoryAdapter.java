package com.petproject.appcustomer.infrastructure.repositories.bodysize;

import com.petproject.appcustomer.domain.models.in.BodySizeEntity;
import com.petproject.appcustomer.domain.ports.out.BodySizeRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.BodySizeDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.BodySizeMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaBodySizeEntityRepositoryAdapter implements BodySizeRepositoryPort {

    private final JpaBodySizeEntityRepository jpaBodySizeEntityRepository;

    @Override
    public List<BodySizeDTO> getAllBodySize() {
        List<BodySizeEntity> bodySizeEntities = jpaBodySizeEntityRepository.getAllBodySize(Boolean.TRUE);
        if (bodySizeEntities.isEmpty())
            throw new NotFoundException("No customer records found.", "201-01", HttpStatus.NOT_FOUND);
        return bodySizeEntities.stream().map(BodySizeMapper.INSTANCE::toDomainModel).toList();
    }
}

package com.petproject.appcustomer.infrastructure.repositories.petcategory;

import com.petproject.appcustomer.domain.models.in.PetCategoryEntity;
import com.petproject.appcustomer.domain.ports.out.PetCategoryRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetCategoryDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.PetCategoryMapper;
import com.petproject.appcustomer.infrastructure.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class JpaPetCategoryRepositoryAdapter implements PetCategoryRepositoryPort {

    private JpaPetCategoryRepository jpaPetCategoryRepository;

    @Override
    public List<PetCategoryDTO> getAllPetCategory() {
        List<PetCategoryEntity> petCategoryEntities = jpaPetCategoryRepository.findAllByActive(Boolean.TRUE);
        if (petCategoryEntities.isEmpty())
            throw new NotFoundException(Constants.MESSAGE_NOT_FOUND, "201-01", HttpStatus.NOT_FOUND);
        return petCategoryEntities
                .stream()
                .map(PetCategoryMapper.INSTANCE::toDomainModel)
                .toList();
    }
}

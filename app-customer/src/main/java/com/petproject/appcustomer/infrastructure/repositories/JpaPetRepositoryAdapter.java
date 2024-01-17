package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.PetMapper;
import com.petproject.appcustomer.infrastructure.repositories.color.JpaColorEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaPetRepositoryAdapter implements PetRepositoryPort {

    private final JpaPetRepository jpaPetRepository;

    private final JpaCustomerRepository jpaCustomerRepository;
    private final JpaColorEntityRepository jpaColorEntityRepository;
    private final JpaBodySizeEntityRepository jpaBodySizeEntityRepository;
    private final JpaTypeFigureEntityRepository jpaTypeFigureEntityRepository;

    @Override
    public PetDTO save(PetDTO dto) {
        PetEntity newPetEntity = PetMapper.INSTANCE.fromDomainModel(dto);

        jpaCustomerRepository.findById(dto.getIdCustomerEntity()).ifPresent(newPetEntity::setCustomerEntity);
        jpaColorEntityRepository.findById(dto.getIdHairColorEntity()).ifPresent(newPetEntity::setHairColorEntity);
        jpaBodySizeEntityRepository.findById(dto.getIdBodySizeEntity()).ifPresent(newPetEntity::setBodySizeEntity);
        jpaTypeFigureEntityRepository.findById(dto.getIdTypeFigureEntity()).ifPresent(newPetEntity::setTypeFigureEntity);
        jpaColorEntityRepository.findById(dto.getIdEyeColorEntity()).ifPresent(newPetEntity::setEyeColorEntity);

        PetEntity savedPetEntity = jpaPetRepository.save(newPetEntity);
        return PetMapper.INSTANCE.toDomainModel(savedPetEntity);
    }

    @Override
    public Optional<PetDTO> findById(Integer id) {
        return jpaPetRepository.findById(id).map(PetMapper.INSTANCE::toDomainModel);
    }

    @Override
    public List<PetDTO> findAll() {
        List<PetEntity> petEntities = jpaPetRepository.findAll();
        if (petEntities.isEmpty())
            throw new NotFoundException("No pet result.", "201-02", HttpStatus.NOT_FOUND);
        return petEntities.stream().map(PetMapper.INSTANCE::toDomainModel).toList();
    }

    @Override
    public PetDTO update(Integer id, PetDTO dto) {
        Optional<PetEntity> optionalPetEntity = jpaPetRepository.findById(id);
        if (optionalPetEntity.isPresent()) {
            optionalPetEntity.get().setName(dto.getName());
            optionalPetEntity.get().setPhoto(dto.getPhoto());
            optionalPetEntity.get().setBirthdate(LocalDate.parse(dto.getBirthdate()));
            optionalPetEntity.get().setAge(dto.getAge());
            optionalPetEntity.get().setGender(dto.getGender());
            optionalPetEntity.get().setPetCategory(dto.getPetCategory());
            optionalPetEntity.get().setRace(dto.getRace());
            optionalPetEntity.get().setWeight(dto.getWeight());
            optionalPetEntity.get().setCharacteristicsExtremities(dto.getCharacteristicsExtremities());

            jpaColorEntityRepository.findById(dto.getIdHairColorEntity()).ifPresent(colorEntity -> optionalPetEntity.get().setHairColorEntity(colorEntity));
            jpaBodySizeEntityRepository.findById(dto.getIdBodySizeEntity()).ifPresent(bodySizeEntity -> optionalPetEntity.get().setBodySizeEntity(bodySizeEntity));
            jpaTypeFigureEntityRepository.findById(dto.getIdTypeFigureEntity()).ifPresent(typeFigureEntity -> optionalPetEntity.get().setTypeFigureEntity(typeFigureEntity));
            jpaColorEntityRepository.findById(dto.getIdEyeColorEntity()).ifPresent(colorEntity -> optionalPetEntity.get().setEyeColorEntity(colorEntity));

            PetEntity updatePetEntity = jpaPetRepository.save(optionalPetEntity.get());
            return PetMapper.INSTANCE.toDomainModel(updatePetEntity);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<PetEntity> optionalPetEntity = jpaPetRepository.findById(id);
        optionalPetEntity.ifPresent(jpaPetRepository::delete);
        return !jpaPetRepository.existsById(id);
    }
}

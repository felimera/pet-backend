package com.petproject.appcustomer.infrastructure.repositories.pet;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.domain.models.in.enums.Gender;
import com.petproject.appcustomer.domain.ports.out.PetRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.PetDTO;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.PetMapper;
import com.petproject.appcustomer.infrastructure.repositories.JpaCustomerRepository;
import com.petproject.appcustomer.infrastructure.repositories.color.JpaColorEntityRepository;
import com.petproject.appcustomer.infrastructure.repositories.massunits.JpaMassMeasurementUnitsRepository;
import com.petproject.appcustomer.infrastructure.repositories.race.JpaRaceRepository;
import com.petproject.appcustomer.infrastructure.repositories.typefigure.JpaTypeFigureEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaPetRepositoryAdapter implements PetRepositoryPort {

    private final JpaPetRepository jpaPetRepository;

    private final JpaCustomerRepository jpaCustomerRepository;
    private final JpaColorEntityRepository jpaColorEntityRepository;
    private final JpaTypeFigureEntityRepository jpaTypeFigureEntityRepository;
    private final JpaMassMeasurementUnitsRepository jpaMassMeasurementUnitsRepository;
    private final JpaRaceRepository jpaRaceRepository;


    @Override
    public PetDTO save(PetDTO dto) {
        PetEntity newPetEntity = PetMapper.INSTANCE.fromDomainModel(dto);

        jpaCustomerRepository.findById(dto.getIdCustomerEntity()).ifPresent(newPetEntity::setCustomerEntity);
        jpaColorEntityRepository.findById(dto.getIdHairColorEntity()).ifPresent(newPetEntity::setHairColorEntity);
        jpaTypeFigureEntityRepository.findById(dto.getIdTypeFigureEntity()).ifPresent(newPetEntity::setTypeFigureEntity);
        jpaColorEntityRepository.findById(dto.getIdEyeColorEntity()).ifPresent(newPetEntity::setEyeColorEntity);
        jpaMassMeasurementUnitsRepository.findById(dto.getIdMassMeasurementUnitsEntity()).ifPresent(newPetEntity::setMassMeasurementUnitsEntity);
        jpaRaceRepository.findById(dto.getIdRaceEntity()).ifPresent(newPetEntity::setRaceEntity);

        newPetEntity.setCreationDate(LocalDateTime.now());
        newPetEntity.setModificationDate(LocalDateTime.now());

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
            optionalPetEntity.get().setGender(Gender.getName(dto.getGender()));
            optionalPetEntity.get().setWeightValue(dto.getWeightValue());
            optionalPetEntity.get().setCharacteristicsExtremities(dto.getCharacteristicsExtremities());

            jpaColorEntityRepository.findById(dto.getIdHairColorEntity()).ifPresent(colorEntity -> optionalPetEntity.get().setHairColorEntity(colorEntity));
            jpaTypeFigureEntityRepository.findById(dto.getIdTypeFigureEntity()).ifPresent(typeFigureEntity -> optionalPetEntity.get().setTypeFigureEntity(typeFigureEntity));
            jpaColorEntityRepository.findById(dto.getIdEyeColorEntity()).ifPresent(colorEntity -> optionalPetEntity.get().setEyeColorEntity(colorEntity));
            jpaCustomerRepository.findById(dto.getIdCustomerEntity()).ifPresent(customerEntity -> optionalPetEntity.get().setCustomerEntity(customerEntity));
            jpaMassMeasurementUnitsRepository.findById(dto.getIdMassMeasurementUnitsEntity()).ifPresent(massMeasurementUnitsEntity -> optionalPetEntity.get().setMassMeasurementUnitsEntity(massMeasurementUnitsEntity));
            jpaRaceRepository.findById(dto.getIdRaceEntity()).ifPresent(raceEntity -> optionalPetEntity.get().setRaceEntity(raceEntity));

            optionalPetEntity.get().setModificationDate(LocalDateTime.now());

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

    @Override
    public List<PetDTO> getPetMultipleParameter(PetSearch petSearch) {
        List<PetEntity> petEntities = jpaPetRepository.getPetMultipleParameter(petSearch);
        if (petEntities.isEmpty())
            throw new NotFoundException("No pet result.", "201-02", HttpStatus.NOT_FOUND);
        return petEntities.stream().map(PetMapper.INSTANCE::toDomainModel).toList();
    }
}

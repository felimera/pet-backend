package com.petproject.appcustomer.infrastructure.repositories.pet;

import com.petproject.appcustomer.domain.models.in.PetEntity;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;

import java.util.List;

public interface JpaPetCriteriaRepository {

    List<PetEntity> getPetMultipleParameter(PetSearch petSearch);
}

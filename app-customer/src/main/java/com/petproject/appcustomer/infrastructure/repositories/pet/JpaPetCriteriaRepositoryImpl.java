package com.petproject.appcustomer.infrastructure.repositories.pet;

import com.petproject.appcustomer.domain.models.in.*;
import com.petproject.appcustomer.infrastructure.entities.search.PetSearch;
import com.petproject.appcustomer.infrastructure.util.Constants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaPetCriteriaRepositoryImpl implements JpaPetCriteriaRepository {

    private EntityManager em;

    @Autowired
    public JpaPetCriteriaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<PetEntity> getPetMultipleParameter(PetSearch petSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PetEntity> cq = cb.createQuery(PetEntity.class);
        List<Predicate> predicateList = new ArrayList<>();
        Root<PetEntity> petEntityRoot = cq.from(PetEntity.class);

        Join<PetEntity, CustomerEntity> petEntityCustomerEntityJoin = petEntityRoot.join(PetEntity_.CUSTOMER_ENTITY, JoinType.INNER);
        Join<RaceEntity, CustomerEntity> raceEntityCustomerEntityJoin = petEntityRoot.join(PetEntity_.RACE_ENTITY, JoinType.INNER);

        if (Objects.nonNull(petSearch.getNamePet()))
            predicateList.add(cb.like(petEntityRoot.get(PetEntity_.NAME), Constants.PERCENTAGE + petSearch.getNamePet() + Constants.PERCENTAGE));
        if (Objects.nonNull(petSearch.getNameOwner())) {
            Expression<String> nameExpression = cb.upper(cb.concat(petEntityCustomerEntityJoin.get(CustomerEntity_.FIRST_NAME), petEntityCustomerEntityJoin.get(CustomerEntity_.LAST_NAME)));
            predicateList.add(cb.like(nameExpression, Constants.PERCENTAGE + petSearch.getNameOwner().toUpperCase() + Constants.PERCENTAGE));
        }
        if (Objects.nonNull(petSearch.getIdRaceEntity()))
            predicateList.add(cb.equal(raceEntityCustomerEntityJoin.get(RaceEntity_.ID), petSearch.getIdRaceEntity()));

        if (!predicateList.isEmpty()) {
            cq.where(predicateList.toArray(new Predicate[0]));
            return em.createQuery(cq).getResultList();
        }
        return new ArrayList<>();
    }
}

package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.models.in.CustomerEntity_;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaCustomerCriteriaRepositoryImpl implements JpaCustomerCriteriaRepository {

    private EntityManager em;

    @Autowired
    public JpaCustomerCriteriaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CustomerEntity> getCustomerMultipleParameter(CustomerSearch customerSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> cq = cb.createQuery(CustomerEntity.class);
        List<Predicate> predicateList = new ArrayList<>();
        Root<CustomerEntity> customerEntityRoot = cq.from(CustomerEntity.class);

        if (Objects.nonNull(customerSearch.getFirstName()))
            predicateList.add(cb.like(customerEntityRoot.get(CustomerEntity_.FIRST_NAME), "%" + customerSearch.getFirstName() + "%"));
        if (Objects.nonNull(customerSearch.getLastName()))
            predicateList.add(cb.like(customerEntityRoot.get(CustomerEntity_.LAST_NAME), "%" + customerSearch.getLastName() + "%"));
        if (Objects.nonNull(customerSearch.getPhone()))
            predicateList.add(cb.like(customerEntityRoot.get(CustomerEntity_.PHONE), "%" + customerSearch.getPhone() + "%"));
        if (Objects.nonNull(customerSearch.getEmail()))
            predicateList.add(cb.like(customerEntityRoot.get(CustomerEntity_.EMAIL), "%" + customerSearch.getEmail() + "%"));
        if (Objects.nonNull(customerSearch.getIds()))
            predicateList.add(customerEntityRoot.get(CustomerEntity_.USER_ID).in(customerSearch.getIds()).not());

        if (!predicateList.isEmpty()) {
            cq.where(predicateList.toArray(new Predicate[0]));
            return em.createQuery(cq).getResultList();
        }
        return new ArrayList<>();
    }
}

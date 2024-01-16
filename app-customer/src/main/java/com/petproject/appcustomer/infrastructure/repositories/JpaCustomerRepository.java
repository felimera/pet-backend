package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Integer>, JpaCustomerCriteriaRepository {
    @Query("select c from  CustomerEntity c where c.userId=:idUser")
    Optional<CustomerEntity> getCustomerByUserId(Integer idUser);

    Optional<CustomerEntity> findOneByEmail(String email);

    @Query("select c from CustomerEntity c where c.userId in :ids")
    List<CustomerEntity> getCustomerByListId(List<Integer> ids);
}

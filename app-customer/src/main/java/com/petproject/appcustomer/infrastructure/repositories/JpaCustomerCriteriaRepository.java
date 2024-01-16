package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.infrastructure.entities.search.CustomerSearch;

import java.util.List;

public interface JpaCustomerCriteriaRepository {
    List<CustomerEntity> getCustomerMultipleParameter(CustomerSearch customerSearch);
}

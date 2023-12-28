package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerEntity newCustomerEntity = CustomerMapper.INSTANCE.fromDomainModel(customerDTO);
        CustomerEntity savedCustomerEntity = jpaCustomerRepository.save(newCustomerEntity);
        return CustomerMapper.INSTANCE.toDomainModel(savedCustomerEntity);
    }

    @Override
    public Optional<CustomerDTO> findById(Integer id) {
        return jpaCustomerRepository.findById(id).map(CustomerMapper.INSTANCE::toDomainModel);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerEntity> customerEntities = jpaCustomerRepository.findAll();
        if (customerEntities.isEmpty())
            throw new NotFoundException("No customer records found.", "201-01", HttpStatus.NOT_FOUND);
        return customerEntities.stream().map(CustomerMapper.INSTANCE::toDomainModel).toList();
    }

    @Override
    public CustomerDTO update(Integer id, CustomerDTO dto) {
        Optional<CustomerEntity> oldCustomerEntityOptional = jpaCustomerRepository.findById(id);
        if (oldCustomerEntityOptional.isPresent()) {
            oldCustomerEntityOptional.get().setFirstName(dto.getFirstName());
            oldCustomerEntityOptional.get().setLastName(dto.getLastName());
            oldCustomerEntityOptional.get().setPhone(dto.getPhone());
            oldCustomerEntityOptional.get().setIsOlder(dto.getIsOlder());

            CustomerEntity savedCustomerEntity = jpaCustomerRepository.save(oldCustomerEntityOptional.get());
            return CustomerMapper.INSTANCE.toDomainModel(savedCustomerEntity);
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<CustomerEntity> oldCustomerEntityOptional = jpaCustomerRepository.findById(id);
        oldCustomerEntityOptional.ifPresent(jpaCustomerRepository::delete);
        return !jpaCustomerRepository.existsById(id);
    }
}

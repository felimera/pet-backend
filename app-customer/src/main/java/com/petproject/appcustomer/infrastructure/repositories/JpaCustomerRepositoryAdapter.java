package com.petproject.appcustomer.infrastructure.repositories;

import com.petproject.appcustomer.domain.models.in.CustomerEntity;
import com.petproject.appcustomer.domain.models.in.UserEntity;
import com.petproject.appcustomer.domain.ports.out.CustomerRepositoryPort;
import com.petproject.appcustomer.domain.ports.out.UserExternalServicePort;
import com.petproject.appcustomer.infrastructure.entities.CustomerDTO;
import com.petproject.appcustomer.infrastructure.exception.BusinessException;
import com.petproject.appcustomer.infrastructure.exception.NotFoundException;
import com.petproject.appcustomer.infrastructure.mapper.CustomerMapper;
import com.petproject.appcustomer.infrastructure.util.CadenaUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final UserExternalServicePort userExternalServicePort;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        if (isExistEmailCustomer(customerDTO.getEmail())) {
            throw new BusinessException("415", HttpStatus.BAD_REQUEST, "The email already exists.");
        }
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
            oldCustomerEntityOptional.get().setIsOlder(CadenaUtil.convertTrueFalse(dto.getIsOlder()));

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

    @Override
    public CustomerDTO getCustomerByEmailUser(String emailUser) {
        UserEntity user = userExternalServicePort.getUserByEmail(emailUser);

        CustomerEntity customerEntity = jpaCustomerRepository.getCustomerByUserId(user.getId()).orElseThrow();
        return CustomerMapper.INSTANCE.toDomainModel(customerEntity);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        CustomerEntity customerEntity = jpaCustomerRepository.findOneByEmail(email).orElseThrow();
        return CustomerMapper.INSTANCE.toDomainModel(customerEntity);
    }

    @Override
    public List<CustomerDTO> getAllCustomerByRole(String role) {
        List<Integer> integerList = userExternalServicePort.getUserByRole(role).stream().map(UserEntity::getId).toList();
        List<CustomerEntity> customerEntities = jpaCustomerRepository.getCustomerByListId(integerList);
        customerEntities.forEach(customerEntity -> {
            customerEntity.setFirstName(CadenaUtil.toUppercase(customerEntity.getFirstName()));
            customerEntity.setLastName(CadenaUtil.toUppercase(customerEntity.getLastName()));
        });
        return customerEntities.stream().map(CustomerMapper.INSTANCE::toDomainModel).toList();
    }

    public boolean isExistEmailCustomer(String email) {
        Optional<CustomerEntity> customerEntityOptional = jpaCustomerRepository.findOneByEmail(email);
        return customerEntityOptional.isPresent();
    }
}

package com.project.appmedia.repository;

import com.project.appmedia.models.PhotoPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoPetRepository extends JpaRepository<PhotoPet, Integer> {

    boolean existsByName(String name);

    List<PhotoPet> findAllByPetId(Integer petId);
}

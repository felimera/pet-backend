package com.project.appmedia;

import com.project.appmedia.models.PhotoPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoPetRepository extends JpaRepository<PhotoPet, Integer> {
}

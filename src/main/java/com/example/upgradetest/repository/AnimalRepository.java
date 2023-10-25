package com.example.upgradetest.repository;

import com.example.upgradetest.domain.entity.AnimalInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<AnimalInventory, Long> {

    Optional<AnimalInventory> findByUserIdAndAnimalId(Integer userId, Integer animalId);

}

package com.example.upgradetest.repository;

import com.example.upgradetest.domain.entity.AnimalInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalInventory, Long> {

    AnimalInventory findByUserIdAndAnimalId(Integer userId, Integer animalId);

}

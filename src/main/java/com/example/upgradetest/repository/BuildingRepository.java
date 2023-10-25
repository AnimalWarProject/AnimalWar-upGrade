package com.example.upgradetest.repository;

import com.example.upgradetest.domain.entity.AnimalInventory;
import com.example.upgradetest.domain.entity.BuildingInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingRepository extends JpaRepository<BuildingInventory, Long> {

    Optional<BuildingInventory> findByUserIdAndBuildingId(Integer userId, Integer animalId);

}

package com.example.upgradetest.repository;

import com.example.upgradetest.domain.entity.AnimalInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<AnimalInventory, Long> {

    @Query("SELECT AnimalInventory FROM AnimalInventory A WHERE A.id=:animalId")
    Optional<AnimalInventory> findById(Integer animalId);

}

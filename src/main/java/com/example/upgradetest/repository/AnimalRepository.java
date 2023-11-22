package com.example.upgradetest.repository;


import com.example.upgradetest.domain.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query("SELECT A FROM Animal A WHERE A.animalId=:itemId")
    Animal findByitemId(Long itemId);

}

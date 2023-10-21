package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.AnimalInventory;
import com.example.upgradetest.domain.request.SaveRequest;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;

    public void save(SaveRequest request){
        animalRepository.save(request.toEntity());
    }

    public ResultResponse upgrade(Integer userId, Integer animalId) {
        AnimalInventory findAnimal = animalRepository.findByUserIdAndAnimalId(userId, animalId); // 인벤토리에서 강화할 동물을 가져왔다.


        return
    }


}

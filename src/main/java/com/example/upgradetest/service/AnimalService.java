package com.example.upgradetest.service;

import com.example.upgradetest.domain.dto.SendResultUpgrade;
import com.example.upgradetest.domain.entity.AnimalInventory;
import com.example.upgradetest.domain.request.UpgradeRequest;
import com.example.upgradetest.domain.response.ResultResponse;
import com.example.upgradetest.kafka.KafkaProducerService;
import com.example.upgradetest.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final KafkaProducerService kafkaProducerService;




//    public void save(SaveRequest request) { // Test용
//        animalRepository.save(request.toEntity());
//    }


    public ResultResponse upgradeAnimal(UpgradeRequest request) {
        AnimalInventory findAnimal = animalRepository.findById(request.animalId())
                .orElseThrow(() -> new NoSuchElementException("잘못된 동물.")); // animalId 없을수도 있습니다.
        Integer resultUpgrade = upgradeMethod(request.buff());

        // Kafka를 통해 결과 전송
        kafkaProducerService.sendResult(new SendResultUpgrade(request.userUUID(), request.animalId(), resultUpgrade));
        return new ResultResponse(findAnimal.getName(), resultUpgrade);
    }

    private Integer upgradeMethod(Integer upgrade) {
        final int randomNumber = (int)(Math.random() * 100);
        final int[] arr = {100, 90, 80, 70, 60, 35, 25, 15, 10}; // 0, 1, 2, 3, 4 ...

        if (randomNumber < arr[upgrade]) {
            upgrade++; // 강화 성공시 강화수치를 +1 증가
            System.out.println("강화 성공");
        } else {
            if (upgrade >= 6) {
                upgrade --; // 실패 시 6 이상인 경우 하락
            }
            System.out.println("강화 실패");
        }
        return upgrade;
    }


//    private void update(AnimalInventory findAnimal, int buff){ // 강화수치 업데이트
//        findAnimal.setBuff(buff);
//    }
}

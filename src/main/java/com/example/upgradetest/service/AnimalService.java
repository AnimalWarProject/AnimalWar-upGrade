package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.Animal;
import com.example.upgradetest.domain.request.UpgradeRequest;
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

    public void upgradeAnimal(UpgradeRequest request) {
        Animal byitemId = animalRepository.findByitemId(request.itemId());
        if (byitemId != null){
            Integer resultUpgrade = upgradeMethod(request.buff());
            kafkaProducerService.sendResult(new UpgradeRequest(request.userUUID(), request.itemId(), resultUpgrade));
        }else {
            System.out.println("잘못된 정보입니다.");
        }

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
}

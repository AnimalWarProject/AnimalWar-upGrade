package com.example.upgradetest.service;

import com.example.upgradetest.domain.entity.Animal;
import com.example.upgradetest.domain.request.AnimalUpgradeRequest;
import com.example.upgradetest.kafka.KafkaProducerService;
import com.example.upgradetest.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final KafkaProducerService kafkaProducerService;

    public boolean upgradeAnimal(AnimalUpgradeRequest request) {
        boolean result = false;
        Animal byitemId = animalRepository.findByitemId(request.itemId());
        if (byitemId != null){
            Integer resultUpgrade = upgradeMethod(request.buff());
            if (resultUpgrade > request.buff()){
                kafkaProducerService.sendResult(new AnimalUpgradeRequest(request.userUUID(), request.itemId(), resultUpgrade));
                result = true;
            }else {
                System.out.println("강화실패");
            }
        }else {
            System.out.println("잘못된 정보입니다.");
        }
        return result;
    }

    private Integer upgradeMethod(Integer upgrade) {
        final int randomNumber = (int)(Math.random() * 100);
        final int[] arr = {100, 90, 80, 70, 60, 35, 25, 15, 10}; // 강화 확률

        if (randomNumber < arr[upgrade]) {
            upgrade++; // 강화 성공시 강화수치를 +1 증가
            System.out.println("강화 성공");
        } else {
            System.out.println("강화실패");
            if (upgrade >= 6) {
                upgrade --; // 실패 시 6 이상인 경우 하락
            }
            System.out.println("강화 실패 장비 하락");
        }
        return upgrade;
    }
}

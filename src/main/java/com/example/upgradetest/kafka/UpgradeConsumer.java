package com.example.upgradetest.kafka;

import com.example.upgradetest.domain.request.UpgradeRequest;
import com.example.upgradetest.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UpgradeConsumer {

    private final AnimalService animalService;

    @KafkaListener(topics = "upgrade-item", groupId = "UpGrade")
    public void animalConsume(UpgradeRequest request) throws IOException {
        System.out.println("강화 consumer : "+request);
        animalService.upgradeAnimal(request);

    }
}
package com.example.upgradetest.kafka;

import com.example.upgradetest.domain.request.AnimalUpgradeRequest;
import com.example.upgradetest.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UpgradeConsumer {

    private final AnimalService animalService;

    @KafkaListener(topics = "upgrade-item", groupId = "upgrade")
    public void animalConsume(AnimalUpgradeRequest request) throws IOException {
        System.out.println("강화 consumer : "+request);
        animalService.upgradeAnimal(request);
    }
}
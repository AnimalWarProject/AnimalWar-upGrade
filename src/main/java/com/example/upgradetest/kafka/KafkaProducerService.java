package com.example.upgradetest.kafka;


import com.example.upgradetest.domain.request.AnimalUpgradeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private static final String TOPIC = "resultUpgrade";
    private final KafkaTemplate<String, AnimalUpgradeRequest> kafkaTemplate;

    public void sendResult(AnimalUpgradeRequest result) {
        System.out.println("Producer : " + result.userUUID() + ", " + result.itemId() + ", " + result.buff());
        kafkaTemplate.send(TOPIC, result);
    }

}
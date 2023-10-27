package com.example.upgradetest.kafka;


import com.example.upgradetest.domain.dto.SendResultUpgrade;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private static final String TOPIC = "resultUpgrade";
    private final KafkaTemplate<String, SendResultUpgrade> kafkaTemplate;

    public void sendResult(SendResultUpgrade result) {
        System.out.println("Producer : " + result.getUserUUID() + " " + result.getAnimalId() + " " + result.getResultUpgrade());
        kafkaTemplate.send(TOPIC, result);
    }

}
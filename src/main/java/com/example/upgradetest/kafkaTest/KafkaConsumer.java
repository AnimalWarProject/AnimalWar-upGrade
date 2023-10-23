package com.example.upgradetest.kafkaTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "foo")
    public void consume(Chatmessage message) throws IOException {
        System.out.println(String.format("Consumed message: %s", message.toString()));

    }
}

package com.toy.kafkaspring.service;

import com.toy.kafkaspring.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, TestDto> kafkaTemplate;

    public void sendMessage(TestDto message) {
        System.out.println("producer :: " + message);
        kafkaTemplate.send("testTopic", message);
    }
}

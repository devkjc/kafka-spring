package com.toy.kafkaspring;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "hello")
    public void consume(String message) {
        System.out.println("consume :: " + message);
    }


}

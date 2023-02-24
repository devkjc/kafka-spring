package com.toy.kafkaspring.service;

import com.toy.kafkaspring.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "testTopic", groupId = "hello")
    public void consume(TestDto testDto) {
        System.out.println("consume :: " + testDto);
    }
}

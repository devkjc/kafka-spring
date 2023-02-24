package com.toy.kafkaspring.service;

import com.toy.kafkaspring.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.dto.name}",
            groupId = "${kafka.topic.dto.group_id}",
            containerFactory = "dtoListenerContainerFactory")
    public void dtoConsume(TestDto testDto) {
        System.out.println("dto Consume :: " + testDto);
    }

    @KafkaListener(topics = "${kafka.topic.string.name}",
            groupId = "${kafka.topic.string.group_id}",
            containerFactory = "stringListenerContainerFactory")
    public void stringConsume(String message) {
        System.out.println("String consume :: " + message);
    }
}

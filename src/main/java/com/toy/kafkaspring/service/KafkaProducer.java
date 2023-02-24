package com.toy.kafkaspring.service;

import com.toy.kafkaspring.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, TestDto> dtoKafkaTemplate;
    private final KafkaTemplate<String, String> stringKafkaTemplate;

    @Value("${kafka.topic.string.name}")
    private String stringTopic;
    @Value("${kafka.topic.dto.name}")
    private String dtoTopic;

    public void sendMessageDto(TestDto dto) {
        dtoKafkaTemplate.send(dtoTopic, dto);
    }

    public void sendMessageString(String message) {
        stringKafkaTemplate.send(stringTopic, message);
    }
}

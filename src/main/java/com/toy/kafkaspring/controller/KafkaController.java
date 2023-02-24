package com.toy.kafkaspring.controller;

import com.toy.kafkaspring.dto.TestDto;
import com.toy.kafkaspring.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody TestDto testDto) {
        kafkaProducer.sendMessage(testDto);
        return ResponseEntity.ok().build();
    }

}

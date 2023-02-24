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

    @PostMapping("/dto")
    public ResponseEntity<Void> sendMessageDto(@RequestBody TestDto testDto) {
        kafkaProducer.sendMessageDto(testDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/string")
    public ResponseEntity<Void> sendMessageString(@RequestParam String message) {
        kafkaProducer.sendMessageString(message);
        return ResponseEntity.ok().build();
    }

}

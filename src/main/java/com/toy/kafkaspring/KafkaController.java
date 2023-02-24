package com.toy.kafkaspring;

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

    @GetMapping
    public ResponseEntity<Void> sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}

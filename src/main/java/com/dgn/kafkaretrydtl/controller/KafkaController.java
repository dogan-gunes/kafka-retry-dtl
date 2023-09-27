package com.dgn.kafkaretrydtl.controller;

import com.dgn.kafkaretrydtl.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/sendMessage/{message}")
    public ResponseEntity<Void> sendMessage(@PathVariable String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().build();

    }
}

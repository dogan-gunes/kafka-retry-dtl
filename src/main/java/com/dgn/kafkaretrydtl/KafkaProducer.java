package com.dgn.kafkaretrydtl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        logger.info("Mesaj gönderiliyor ...  {}",message);

        kafkaTemplate.send("message",message);

        logger.info("Mesaj gönderildi !!! ...  {}",message);
    }
}

package by.ita.se.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "myTopic";

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        List <String> my = new ArrayList<>();
        logger.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send(TOPIC, message);

    }
}
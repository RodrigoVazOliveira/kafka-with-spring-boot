package dev.devaz.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventRegisterService {
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public EventRegisterService(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private <T> void addEvent(final String topic, T data) {
        kafkaTemplate.send(topic, data);
    }
}

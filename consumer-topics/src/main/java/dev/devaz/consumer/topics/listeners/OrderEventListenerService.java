package dev.devaz.consumer.topics.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListenerService {

    @KafkaListener(topics = {"save_order"})
    void saveOrder(final String orderData) {
        System.out.printf("save order - order %s\n", orderData);
    }

}

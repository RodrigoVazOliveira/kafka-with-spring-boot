package dev.devaz.consumer.topics.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.devaz.data.OrderData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListenerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderEventListenerService.class);

    @KafkaListener(topics = {"save_order"}, groupId = "module_save_order")
    void saveOrder(final ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {

        LOGGER.info("chave: {}", consumerRecord.key());
        LOGGER.info("cabeçalhos: {}", consumerRecord.headers());
        LOGGER.info("partições: {}", consumerRecord.partition());

        final String value = consumerRecord.value();
        final ObjectMapper objectMapper = new ObjectMapper();
        OrderData orderData = objectMapper.readValue(value, OrderData.class);

        LOGGER.info("orderData: {}", orderData);
    }

}

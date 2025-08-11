package com.example.uber_ride_Task;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RideKafkaProducer {
	private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String topic = "uber-ride-topic";

    public RideKafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(Object payload) throws Exception {
        String json = objectMapper.writeValueAsString(payload);
        kafkaTemplate.send(topic, json);
    }

}

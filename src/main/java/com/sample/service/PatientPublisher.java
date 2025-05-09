package com.sample.service;

import com.sample.dto.PatientDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PatientPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public PatientPublisher(RabbitTemplate rabbitTemplate,
                            @Value("${rabbitmq.exchange}") String exchange,
                            @Value("${rabbitmq.routing-key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void publish(PatientDTO patientDTO) {
        rabbitTemplate.convertAndSend(exchange, routingKey, patientDTO);
    }
}

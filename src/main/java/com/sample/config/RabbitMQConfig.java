package com.sample.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public DirectExchange patientExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue patientQueue() {
        return new Queue("patient-queue", true);
    }

    @Bean
    public Binding binding(Queue patientQueue, DirectExchange patientExchange) {
        return BindingBuilder.bind(patientQueue).to(patientExchange).with(routingKey);
    }
}


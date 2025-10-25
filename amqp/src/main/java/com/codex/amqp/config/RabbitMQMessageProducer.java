package com.codex.amqp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQMessageProducer {
  private final AmqpTemplate amqpTemplate;

  public RabbitMQMessageProducer(@Qualifier("amqpTemplate") AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  // to publish messages to the queue
  public void publish(Object payload, String exchange, String routingKey) {
    log.info(
        "Publishing message to exchange: {} with routing key: {} payload: {}",
        exchange,
        routingKey,
        payload);
    amqpTemplate.convertAndSend(exchange, routingKey, payload);
    log.info(
        "Published message to exchange: {} with routing key: {} payload: {}",
        exchange,
        routingKey,
        payload);
  }
}

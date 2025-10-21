package com.codex.notification;

import com.codex.amqp.config.RabbitMQMessageProducer;
import com.codex.notification.config.NotificationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
    scanBasePackages = {
        "com.codex.notification",
        "com.codex.amqp"
    }
)
@EnableDiscoveryClient
@Slf4j
public class NotificationApplication {
  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }
  @Bean
  CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig config){
    return args -> {
      producer.publish("testRabbitMessage",config.getInternalExchange(),config.getInternalNotificationRoutingKey());
      log.info("Notification microservice started");
    };
  }
}

package com.codex.notification.rabbitmq;

import com.codex.clients.notification.request.NotificationRequest;
import com.codex.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
  private final NotificationService notificationService;

  @RabbitListener(queues = "${rabbitmq.queues.notification}")
  public void consumer(NotificationRequest notificationRequest){
    log.info("consume {}",notificationRequest);
    notificationService.send(notificationRequest);
  }
}

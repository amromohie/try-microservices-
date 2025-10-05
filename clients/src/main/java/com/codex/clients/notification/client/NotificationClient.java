package com.codex.clients.notification.client;

import com.codex.clients.notification.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification")
public interface NotificationClient {

  @PostMapping(path = "api/v1/notification")
  void sendNotification(NotificationRequest request);
}

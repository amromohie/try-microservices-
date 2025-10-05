package com.codex.notification.controller;

import com.codex.clients.notification.request.NotificationRequest;
import com.codex.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/notification")
@Slf4j
@RequiredArgsConstructor
public class NotificationController {
  private final NotificationService notificationService;

  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest request){



    notificationService.send(request);
  }

}

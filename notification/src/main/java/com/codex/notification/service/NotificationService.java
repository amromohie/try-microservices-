package com.codex.notification.service;

import com.codex.clients.notification.request.NotificationRequest;
import com.codex.notification.entity.Notification;
import com.codex.notification.repository.NotificationRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {
  private final NotificationRepository notificationRepository;
  public void send(NotificationRequest request) {

    notificationRepository.save(
        Notification.builder()
            .toCustomerEmail(request.getToCustomerEmail())
            .toCustomerId(request.getToCustomerId())
            .sender("codex")
            .message(request.getMessage())
            .sentAt(LocalDateTime.now())
            .build());

    log.info("Sending notification:{}", request);
  }
}

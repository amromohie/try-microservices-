package com.codex.notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Notification {
  @Id
  @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence", allocationSize = 1)
  @GeneratedValue(generator = "notification_id_sequence",strategy = GenerationType.SEQUENCE)
  @Column(name = "notification_id")
  private Long notificationId;
  private String message;
  private String sender;
  @Column(name = "sent_at")
  private LocalDateTime sentAt;
  @Column(name = "to_customer_email")
  private String toCustomerEmail;
  @Column(name = "to_customer_id")
  private Long toCustomerId;
}

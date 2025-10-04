package com.codex.fraud.entity;

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

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FraudCheckHistory {
  @Id
  @SequenceGenerator(
      name = "fraud_id_sequence",
      sequenceName = "fraud_id_sequence",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
  private Long id;
  private Long customerId;
  private boolean isFraudster;
  private LocalDateTime createdAt;
}

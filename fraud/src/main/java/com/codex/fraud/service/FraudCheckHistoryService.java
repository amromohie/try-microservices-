package com.codex.fraud.service;

import com.codex.fraud.entity.FraudCheckHistory;
import com.codex.fraud.repository.FraudCheckHistoryRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FraudCheckHistoryService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public boolean isFraudulentCustomer(Long customerId) {

    fraudCheckHistoryRepository.save(FraudCheckHistory.builder().customerId(customerId)
        .isFraudster(false)
        .createdAt(LocalDateTime.now())
        .build());

    return false;
  }

}

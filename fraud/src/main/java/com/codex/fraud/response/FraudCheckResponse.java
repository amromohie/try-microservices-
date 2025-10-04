package com.codex.fraud.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudCheckResponse {
  private boolean isFraudster;
}

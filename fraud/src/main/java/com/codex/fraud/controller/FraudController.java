package com.codex.fraud.controller;

import com.codex.fraud.response.FraudCheckResponse;
import com.codex.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {
  private final FraudCheckHistoryService fraudCheckHistoryService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId){
    boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
    return new FraudCheckResponse(isFraudulentCustomer);
  }
}

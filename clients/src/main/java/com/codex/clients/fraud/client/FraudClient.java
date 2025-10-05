package com.codex.clients.fraud.client;

import com.codex.clients.fraud.response.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fraud")
public interface FraudClient {

  @GetMapping(path = "api/v1/fraud/{customerId}")
  FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId);

}

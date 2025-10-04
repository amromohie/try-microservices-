package com.codex.customer.controller;

import com.codex.customer.request.CustomerRegistrationRequest;
import com.codex.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
    customerService.registerCustomer(request);
    log.info("New customer registration:{}", request);
  }
}

package com.codex.customer.service;

import com.codex.customer.entity.Customer;
import com.codex.customer.request.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

  public void registerCustomer(CustomerRegistrationRequest request) {

    Customer customer =
        Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .build();
    // Registration logic here
    log.info("New customer registration:{}", customer);

  }
}

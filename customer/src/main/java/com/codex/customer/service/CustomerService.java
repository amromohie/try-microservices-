package com.codex.customer.service;

import com.codex.customer.entity.Customer;
import com.codex.customer.repository.CustomerRepository;
import com.codex.customer.request.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;

  public void registerCustomer(CustomerRegistrationRequest request) {

    Customer customer =
        Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .build();
    // Registration logic here
    log.info("New customer registration:{}", customer);
    customerRepository.save(customer);
  }
}

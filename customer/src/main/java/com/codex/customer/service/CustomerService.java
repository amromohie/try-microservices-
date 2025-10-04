package com.codex.customer.service;

import com.codex.customer.entity.Customer;
import com.codex.customer.repository.CustomerRepository;
import com.codex.customer.request.CustomerRegistrationRequest;
import com.codex.customer.response.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;
  public void registerCustomer(CustomerRegistrationRequest request) {

    Customer customer =
        Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .build();
    // Registration logic here
    log.info("New customer registration:{}", customer);

    customerRepository.saveAndFlush(customer);

    FraudCheckResponse fraudCheckResponse = restTemplate
        .getForObject("http://localhost:8081/api/v1/fraud/{customerId}",
            FraudCheckResponse.class,customer.getId());

    log.info("customer id : {}",customer.getId());


    if (fraudCheckResponse.isFraudster()){
      throw new IllegalStateException("Fraudster is false");
    }

  }
}

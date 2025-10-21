package com.codex.customer.service;

import com.codex.amqp.config.RabbitMQMessageProducer;
import com.codex.clients.fraud.client.FraudClient;
import com.codex.clients.fraud.response.FraudCheckResponse;
import com.codex.clients.notification.request.NotificationRequest;
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
  private final FraudClient fraudClient;
  private final RabbitMQMessageProducer messageProducer;
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

    log.info("call fraud service");

    //    FraudCheckResponse fraudCheckResponse = restTemplate
    //        .getForObject("http://FRAUD/api/v1/fraud/{customerId}",
    //            FraudCheckResponse.class,customer.getId());

    log.info("customer id : {}", customer.getId());

    FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("Fraudster is false");
    }
    // send notification
    NotificationRequest notificationRequest = NotificationRequest.builder()
        .toCustomerId(customer.getId())
        .toCustomerEmail(customer.getEmail())
        .message("Hi %s, Welcome to Codex ...".formatted(customer.getFirstName()))
        .build();

    messageProducer.publish(notificationRequest,"internal.exchange","internal.notification.routing-key");
    log.info("Notification sent to customer:{}", customer);
  }
}

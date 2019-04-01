package de.javahippie.backinthering.order.customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerClient {

    @Value("${customerservice.uri}")
    String resourceUrl;

    RestTemplate restTemplate;

    public CustomerClient() {
        this.restTemplate = new RestTemplate();
    }

    @CircuitBreaker(name = "customer-cb")
    @RateLimiter(name = "customer-limiter")
    public Customer findCustomerByNumber(String customerNumber) {
        String path = resourceUrl + "/" + customerNumber;
        ResponseEntity<Customer> response = restTemplate.getForEntity(path, Customer.class);
        return response.getBody();
    }

}
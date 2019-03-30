package de.javahippie.backinthering.order.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class CustomerClient {

    @Value("${customerservice.uri}")
    String resourceUrl;

    @Autowired
    RestTemplate restTemplate;

    public Customer findCustomerByNumber(String customerNumber) {
        String path = resourceUrl + "/" + customerNumber;
        ResponseEntity<Customer> response = restTemplate.getForEntity(path, Customer.class);
        return response.getBody();
    }

}
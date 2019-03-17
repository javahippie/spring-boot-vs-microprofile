package de.javahippie.backinthering.complaint.customer;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@ApplicationScoped
public class CustomerClient {

    CustomerService customerService;

    public CustomerClient() {
        try {
            URI uri = new URI("http://localhost:8080/api");
            customerService = RestClientBuilder.newBuilder().baseUri(uri).build(CustomerService.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public Customer findByCustomerNumber(String customerNumber) {
        return customerService.findCustomerByNumber(customerNumber);
    }

}

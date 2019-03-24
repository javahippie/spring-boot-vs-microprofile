package de.javahippie.backinthering.complaint.customer;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;

@ApplicationScoped
public class CustomerClient {

    @Inject
    @ConfigProperty(name = "customerservice.uri")
    private String clientServiceUri;

    CustomerService customerService;

    @PostConstruct
    public void init() {
        try {
            URI uri = new URI(clientServiceUri);
            customerService = RestClientBuilder.newBuilder().baseUri(uri).build(CustomerService.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public Customer findByCustomerNumber(String customerNumber) {
        return customerService.findCustomerByNumber(customerNumber);
    }

}

package de.javahippie.backinthering.complaint.customer;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.net.URI;

@ApplicationScoped
public class CustomerClient {

    @Inject
    @ConfigProperty(name = "customerservice.uri")
    private URI clientServiceUri;

    @Produces
    public CustomerService build() {
        return RestClientBuilder.newBuilder()
                .baseUri(clientServiceUri)
                .build(CustomerService.class);
    }

}
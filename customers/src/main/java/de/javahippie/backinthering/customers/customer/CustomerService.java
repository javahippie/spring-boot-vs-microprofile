package de.javahippie.backinthering.customers.customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/customer")
@RequestScoped
public class CustomerService {

    @Inject
    private CustomerRepository repository;

    @GET
    @Produces("application/json")
    @Path("/{customerNumber}")
    public Response findCustomerByNumber(@PathParam("customerNumber") String customerNumber) {
        Optional<Customer> foundCustomer = repository.findByCustomerNumber(customerNumber);
        if (foundCustomer.isPresent()) {
            return Response.ok(foundCustomer.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("/search")
    public Response searchByCustomerNumber(@QueryParam("searchString") String searchString) {
        List<Customer> foundCustomers = repository.searchByCustomerNumber(searchString);
        return Response.ok(foundCustomers).build();
    }

}

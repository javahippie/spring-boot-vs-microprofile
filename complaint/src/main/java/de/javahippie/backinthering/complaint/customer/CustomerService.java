package de.javahippie.backinthering.complaint.customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

@Path("/customer")
public interface CustomerService {

    @GET
    @Path("/{customerNumber}")
    @Produces("application/json")
    Customer findCustomerByNumber(@PathParam("customerNumber") String customerNumber);

    @GET
    @Path("/search")
    @Produces("application/json")
    List<Customer> searchCustomerByNumber(@QueryParam("searchString") String searchString);

}
package de.javahippie.backinthering.complaint.customer;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Path("/customer")
public interface CustomerService {

    @GET
    @Path("/{customerNumber}")
    @Produces("application/json")
    @Timeout(value = 500, unit = ChronoUnit.MILLIS)
    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.25, delay = 5000L, successThreshold = 1)
    @Fallback(CustomerFallbackHandler.class)
    Customer findCustomerByNumber(@PathParam("customerNumber") String customerNumber);

    @GET
    @Path("/search")
    @Produces("application/json")
    List<Customer> searchCustomerByNumber(@QueryParam("searchString") String searchString);

}
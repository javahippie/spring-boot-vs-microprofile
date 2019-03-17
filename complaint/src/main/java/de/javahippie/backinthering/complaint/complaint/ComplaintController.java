package de.javahippie.backinthering.complaint.complaint;

import de.javahippie.backinthering.complaint.customer.Customer;
import de.javahippie.backinthering.complaint.customer.CustomerClient;
import org.eclipse.microprofile.opentracing.Traced;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Path("/complaint")
@Traced(false)
public class ComplaintController {

    @Inject
    private ComplaintRepository repository;

    @Inject
    private CustomerClient customerClient;

    @GET
    @Produces("application/json")
    @Path("/{reference}")
    public Response findByReference(@PathParam("reference") String reference) {
        Complaint foundComplaint = repository.findByReference(reference);
        return Response.ok(foundComplaint).build();
    }

    @POST
    public Response create(@QueryParam("caption") String caption, @QueryParam("content") String content, @QueryParam("customerNumber") String customerNumber) {
        Customer customer = customerClient.findByCustomerNumber(customerNumber);

        if (customer != null) {
            Complaint complaint = repository.createComplaint(caption, content, customer);
            try {
                return Response.created(new URI("/complaint/" + complaint.getReference())).build();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return Response.serverError().build();
    }

}

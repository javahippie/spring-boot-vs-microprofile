package de.javahippie.backinthering.complaint.complaint;

import de.javahippie.backinthering.complaint.customer.Customer;
import de.javahippie.backinthering.complaint.customer.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/complaint")
public class ComplaintController {

    @Inject
    private ComplaintRepository repository;

    @Inject
    private CustomerService customerService;

    @GET
    @Produces("application/json")
    @Path("/{reference}")
    public Response findByReference(@PathParam("reference") String reference) {
        Complaint foundComplaint = repository.findByReference(reference);
        return Response.ok(foundComplaint).build();
    }

    @POST
    public Response create(@QueryParam("caption") String caption, @QueryParam("content") String content, @QueryParam("customerNumber") String customerNumber) {
        Customer customer = customerService.findCustomerByNumber(customerNumber);
        if (customer != null) {
            Complaint complaint = repository.createComplaint(caption, content, customer);
            return Response.created(constructCreationUri(complaint)).build();
        } else {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAll() {
        return Response.ok(repository.getAll()).build();
    }

    private URI constructCreationUri(Complaint complaint) {
        try {
            return new URI("/complaint/" + complaint.getReference());
        } catch (URISyntaxException e) {
            return null;
        }
    }

}

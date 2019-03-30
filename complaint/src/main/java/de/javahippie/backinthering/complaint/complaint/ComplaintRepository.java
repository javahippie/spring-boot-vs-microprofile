package de.javahippie.backinthering.complaint.complaint;

import de.javahippie.backinthering.complaint.customer.Customer;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ComplaintRepository {

    @Inject
    @Metric(name = "metric.business.complaint.created")
    private Counter counter;

    private List<Complaint> complaints = new ArrayList<>();

    public Complaint createComplaint(String caption, String text, Customer customer) {
        Complaint complaint = new Complaint(caption, text, customer.getCustomerNumber());
        complaints.add(complaint);
        counter.inc();
        return complaint;
    }

    public Complaint findByReference(String reference) {
        return complaints.stream().filter(complaint -> complaint.getReference().equals(reference)).findAny().orElse(null);
    }

    public List<Complaint> getAll() {
        return complaints;
    }

}
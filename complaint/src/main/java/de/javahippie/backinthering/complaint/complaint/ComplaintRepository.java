package de.javahippie.backinthering.complaint.complaint;

import de.javahippie.backinthering.complaint.customer.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ComplaintRepository {

    private List<Complaint> complaints = new ArrayList<>();

    public Complaint createComplaint(String caption, String text, Customer customer) {
        Complaint complaint = new Complaint(caption, text, customer.getCustomerNumber());
        complaints.add(complaint);
        return complaint;
    }

    public Complaint findByReference(String reference) {
        return complaints.stream().filter(complaint -> complaint.getReference().equals(reference)).findAny().orElse(null);
    }

}
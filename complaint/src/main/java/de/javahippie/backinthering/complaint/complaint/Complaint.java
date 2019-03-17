package de.javahippie.backinthering.complaint.complaint;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Complaint {

    private final String reference;

    private final String caption;

    private final String content;

    private final LocalDateTime creationDate;

    private final String customerNumber;

    public Complaint(String caption, String content, String customerNumber) {
        this.reference = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
        this.caption = caption;
        this.content = content;
        this.customerNumber = customerNumber;
    }

    public String getCaption() {
        return caption;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return reference.equals(complaint.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}

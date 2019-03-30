package de.javahippie.backinthering.complaint.customer;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class CustomerFallbackHandler implements FallbackHandler<Customer> {

    @Override
    public Customer handle(ExecutionContext executionContext) {
        return null;
    }
}

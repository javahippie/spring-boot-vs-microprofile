package de.javahippie.backinthering.complaint.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

@Health
@ApplicationScoped
public class ComplaintHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named(ComplaintHealthCheck.class.getSimpleName())
                .withData("datapoint", "0.782")
                .up()
                .build();

    }
}

package de.javahippie.backinthering.order.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        Status status = (jdbcConnectionIsUp() && amqpIsConnected()) ? Status.UP : Status.DOWN;

        return Health
                .status(status)
                .withDetail("datapoint", "my-app-data")
                .build();
    }

    private boolean amqpIsConnected() {
        return true;
    }

    private boolean jdbcConnectionIsUp() {
        return true;
    }

}

package de.javahippie.backinthering.order.order;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository {

    private Counter counter;
    private List<Order> orders = new ArrayList<>();

    public OrderRepository(MeterRegistry registry) {
        this.counter = registry.counter("metric.business.complaint.created");
    }

    public Order createOrder(Order order) {
        this.orders.add(order);
        counter.increment();
        return order;
    }

    public Optional<Order> findByOrderNumber(String orderNumber) {
        return this.orders.stream().filter(order -> order.getOrderNumber().equals(orderNumber)).findAny();
    }

}

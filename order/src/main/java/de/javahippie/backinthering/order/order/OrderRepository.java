package de.javahippie.backinthering.order.order;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public Order createOrder(Order order) {
        this.orders.add(order);
        return order;
    }

    public Optional<Order> findByOrderNumber(String orderNumber) {
        return this.orders.stream().filter(order -> order.getOrderNumber().equals(orderNumber)).findAny();
    }

}

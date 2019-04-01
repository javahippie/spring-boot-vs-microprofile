package de.javahippie.backinthering.order.order;

import de.javahippie.backinthering.order.customer.Customer;
import de.javahippie.backinthering.order.customer.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/{orderNumber}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderNumber") String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber).orElse(null);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam("customerNumber") String customerNumber, @RequestParam("orderText") String orderText) {
        Customer customer = findCustomer(customerNumber);
        Order order = new Order(customerNumber, orderText);
        orderRepository.createOrder(order);
        return ResponseEntity.created(constructCreationUri(order)).build();
    }

    private Customer findCustomer(String customerNumber) {
        return customerClient.findCustomerByNumber(customerNumber);
    }

    private URI constructCreationUri(Order complaint) {
        try {
            return new URI("/api/order/" + complaint.getOrderNumber());
        } catch (URISyntaxException e) {
            return null;
        }
    }
}

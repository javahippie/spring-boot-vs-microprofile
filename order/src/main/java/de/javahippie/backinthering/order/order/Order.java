package de.javahippie.backinthering.order.order;

import java.util.UUID;

public class Order {

    private String orderNumber;
    private String customerNumber;
    private String orderText;

    public Order(String customerNumber, String orderText) {
        this.orderNumber = UUID.randomUUID().toString();
        this.customerNumber = customerNumber;
        this.orderText = orderText;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getOrderText() {
        return orderText;
    }

}

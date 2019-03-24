package de.javahippie.backinthering.customers.customer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerRepository {

    private List<Customer> customers = new ArrayList<>();


    @PostConstruct
    public void init() {
        Customer customer1 = new Customer();
        customer1.setCustomerNumber("CST-12345");
        customer1.setFirstName("Peter");
        customer1.setLastName("Parker");
        customer1.setStreet("Imaginestreet 12");
        customer1.setPostalCode("12345");
        customer1.setCity("Imagity");
        customer1.setPhone("+555 123123123");
        customer1.setEmail(null);

        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setCustomerNumber("CST-23456");
        customer2.setFirstName("Tony");
        customer2.setLastName("Stark");
        customer2.setStreet("Fakestreet 12");
        customer2.setPostalCode("54321");
        customer2.setCity("Faketown");
        customer2.setPhone("+555 123123121");
        customer2.setEmail(null);

        customers.add(customer2);
    }

    public Optional<Customer> findByCustomerNumber(String customerNumber) {

        try {
            Thread.sleep(Double.valueOf(Math.random()*2000).intValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return customers.stream()
                .filter(customer -> customer.getCustomerNumber().equals(customerNumber))
                .findFirst();
    }

    public List<Customer> searchByCustomerNumber(String searchString) {
        return customers.stream()
                .filter(customer -> customer.getCustomerNumber().startsWith(searchString))
                .collect(Collectors.toList());
    }
}

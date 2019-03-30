package de.javahippie.backinthering.order.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "customers", url = "${customerservice.uri}")
public interface CustomerService {

    @GetMapping(value = "/{customerNumber}", produces = "application/json")
    Customer findCustomerByNumber(@PathVariable("customerNumber") String customerNumber);

    @GetMapping(value = "/search", produces = "application/json")
    List<Customer> searchCustomerByNumber(@RequestParam("searchString") String searchString);
}

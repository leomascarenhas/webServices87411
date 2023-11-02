package ca.vanier.customersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {

        customerService.save(customer);

        System.out.println("HELLO");
    }

    @GetMapping("/find")
    public Customer getCustomer(@RequestParam Long id) {
        return customerService.findById(id).get();
    }

    
}

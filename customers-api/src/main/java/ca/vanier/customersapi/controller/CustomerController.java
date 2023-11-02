package ca.vanier.customersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Save
    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {

        customerService.save(customer);

        System.out.println("HELLO");

    }
    
}

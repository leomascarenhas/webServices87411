package ca.vanier.customersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @PostMapping("/")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
        System.out.println("HELLO");
    }

    @GetMapping("/")
    public Customer getCustomer(@RequestParam Long id) {
        Customer customer = customerService.findById(id).get();
        customer.getId();
        System.out.println(customer.toString());
        return customer;
    }

    @DeleteMapping("/")
    public String delete(@RequestParam Long id) {
        customerService.delete(id);
        return "ok";
    }

    
}

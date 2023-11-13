package ca.vanier.customersapi.controller;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @GetMapping("/")
    public Customer getCustomer(@RequestParam Long id) {
        return customerService.findById(id).get();
    }

    @DeleteMapping("/")
    public String delete(@RequestParam Long id) {
        customerService.delete(id);
        return "ok";
    }
    
}

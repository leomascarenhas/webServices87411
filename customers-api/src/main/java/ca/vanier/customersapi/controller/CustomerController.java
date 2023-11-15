package ca.vanier.customersapi.controller;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return savedCustomer != null
                ? new ResponseEntity<>(savedCustomer, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/")
    public ResponseEntity<Customer> getCustomer(@RequestParam Long id) {
        Optional<Customer> customer = customerService.findById(id);

        // do we have a customer?
        return customer.map(
                // if yes: send it, with a success code
                value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))

            // otherwise: send it an error code
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/")
    public String delete(@RequestParam Long id) {
        customerService.delete(id);
        return "ok";
    }
    
}

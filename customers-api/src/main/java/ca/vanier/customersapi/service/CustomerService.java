package ca.vanier.customersapi.service;

import ca.vanier.customers.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    
    Customer save(Customer customer);
    
    Optional<Customer> findById(Long id);

    void update(Long id);

    void delete(Long id);

}

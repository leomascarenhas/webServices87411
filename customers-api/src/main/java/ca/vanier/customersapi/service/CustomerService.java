package ca.vanier.customersapi.service;

import java.util.Optional;

import ca.vanier.customersapi.entity.Customer;

public interface CustomerService {
    
    Customer save(Customer customer);
    
    Optional<Customer> findById(Long id);

    void update(Long id);

    void delete(Long id);

}

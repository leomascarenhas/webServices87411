package ca.vanier.customersapi.service;

import ca.vanier.customersapi.repository.CustomerRepository;
import ca.vanier.customers.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CityService cityService;

    @Override
    public Customer save(Customer customer) {
        if (customer.getAddresses() != null) {
            customer.getAddresses().forEach(address -> {
                address.setCity(cityService.save(address.getCity()));
            });
        }

        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(value -> customerRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(value -> customerRepository.delete(value));
    }
    
}

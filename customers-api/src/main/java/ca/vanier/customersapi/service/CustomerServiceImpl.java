package ca.vanier.customersapi.service;

import ca.vanier.customersapi.entity.Customer;
import ca.vanier.customersapi.repository.CustomerRepository;
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
            customer.getAddresses().forEach(customerAddress -> {
                customerAddress.setCity(cityService.save(customerAddress.getCity()));
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
        if (customer.isPresent()) {
            customerRepository.save(customer.get());
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        }
    }
    
}

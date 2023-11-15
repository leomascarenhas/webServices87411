package ca.vanier.customersapi.service;

import ca.vanier.addresses.entity.City;

import java.util.Optional;

public interface CityService {

    City save(City customer);
    
    Optional<City> findById(Long id);

    void update(Long id);

    void delete(Long id);
    
}

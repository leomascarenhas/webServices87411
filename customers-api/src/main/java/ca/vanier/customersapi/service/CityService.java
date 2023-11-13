package ca.vanier.customersapi.service;

import java.util.Optional;

import ca.vanier.customersapi.entity.City;

public interface CityService {

    City save(City customer);
    
    Optional<City> findById(Long id);

    void update(Long id);

    void delete(Long id);
    
}

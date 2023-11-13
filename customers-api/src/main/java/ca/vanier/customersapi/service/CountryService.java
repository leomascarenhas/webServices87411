package ca.vanier.customersapi.service;

import java.util.Optional;

import ca.vanier.customersapi.entity.Country;

public interface CountryService {
    
    Country save(Country country);
    
    Optional<Country> findById(Long id);

    void update(Long id);

    void delete(Long id);
}

package ca.vanier.customersapi.service;

import ca.vanier.addresses.entity.Country;

import java.util.Optional;

public interface CountryService {
    
    Country save(Country country);
    
    Optional<Country> findById(Long id);

    void update(Long id);

    void delete(Long id);
}

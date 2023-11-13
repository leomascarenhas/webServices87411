package ca.vanier.customersapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.customersapi.entity.Country;
import ca.vanier.customersapi.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        country.ifPresent(value -> countryRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        country.ifPresent(value -> countryRepository.delete(value));
    }
    
}

package ca.vanier.customersapi.service;

import ca.vanier.addresses.entity.City;
import ca.vanier.customersapi.repository.CityRepository;
import ca.vanier.customersapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public City save(City city) {

        // do we have country?
        if (city.getCountry() != null) {
            // if yes, save it
            countryRepository.save(city.getCountry());
        }

        return cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<City> customer = cityRepository.findById(id);
        customer.ifPresent(city -> cityRepository.save(city));
    }

    @Override
    public void delete(Long id) {
        Optional<City> customer = cityRepository.findById(id);
        customer.ifPresent(city -> cityRepository.delete(city));
    }
}

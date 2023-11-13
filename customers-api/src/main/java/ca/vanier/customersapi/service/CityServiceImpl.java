package ca.vanier.customersapi.service;

import ca.vanier.customersapi.entity.City;
import ca.vanier.customersapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City city) {
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

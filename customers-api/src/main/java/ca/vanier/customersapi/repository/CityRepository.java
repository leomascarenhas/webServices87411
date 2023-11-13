package ca.vanier.customersapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.customersapi.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>  {
    
}

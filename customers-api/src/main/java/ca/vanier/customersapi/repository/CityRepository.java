package ca.vanier.customersapi.repository;

import ca.vanier.addresses.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>  {
    
}

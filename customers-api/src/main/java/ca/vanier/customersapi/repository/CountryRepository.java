package ca.vanier.customersapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.customersapi.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>  {
    
}

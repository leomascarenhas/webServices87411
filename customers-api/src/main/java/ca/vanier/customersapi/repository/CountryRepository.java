package ca.vanier.customersapi.repository;

import ca.vanier.addresses.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>  {
    
}

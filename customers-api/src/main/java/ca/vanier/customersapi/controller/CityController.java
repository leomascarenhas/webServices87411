package ca.vanier.customersapi.controller;

import ca.vanier.addresses.entity.City;
import ca.vanier.customersapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;

    @PostMapping("/")
    public ResponseEntity<City> save(@RequestBody City city)  {
        City savedCity = cityService.save(city);
        return savedCity != null
                ? new ResponseEntity<>(savedCity, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/")
    public ResponseEntity<City> findById(@RequestParam Long id) {
        Optional<City> customer = cityService.findById(id);

        // do we have a customer?
        return customer.map(
                        // if yes: send it, with a success code
                        value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))

                // otherwise: send it an error code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/")
    public ResponseEntity<City> delete(@RequestParam Long id) {
        Optional<City> deletedCity = cityService.findById(id);

        if (deletedCity.isPresent()) {
            cityService.delete(id);
            return new ResponseEntity<>(deletedCity.get(), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}

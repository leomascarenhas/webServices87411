package ca.vanier.customersapi.controller;

import ca.vanier.customersapi.entity.City;
import ca.vanier.customersapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;

    @PostMapping("/")
    public void save(@RequestBody City city)  {
        cityService.save(city);
    }

    @DeleteMapping("/")
    public void delete(@RequestParam Long id) {
        cityService.delete(id);
    }

    @GetMapping("/")
    public void findById(@RequestParam Long id) {
        cityService.findById(id);
    }

}

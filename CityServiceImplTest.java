package ca.vanier.customersapi.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.vanier.addresses.entity.City;
import ca.vanier.addresses.entity.Country;

@ExtendWith(SpringExtension.class)
public class CityServiceImplTest {

    @Mock
    CityServiceImpl cityService;

    @Test
    void save() {
        // Setup
        Country canada = new Country();
        canada.setName("Canada");

        City cityToSave = new City();
        cityToSave.setName("Montreal");
        cityToSave.setCountry(canada);

        City cityResult = new City();
        cityResult.setId(2L);
        cityResult.setName("Montreal");
        cityResult.setCountry(canada);

        Mockito
                .when(cityService.save(cityToSave))
                .thenReturn(cityResult);

        // Execution
        cityResult = cityService.save(cityToSave);

        // Assertions
        assert cityResult.getName().equals("Montreal");
        assert cityResult.getId() == 2L;
    }

    @Test
    void findById_isPresent() {
        // Setup
        Country canada = new Country();
        canada.setName("Canada");

        City city = new City();
        city.setId(2L);
        city.setName("Montreal");
        city.setCountry(canada);

        Mockito
                .when(cityService.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(city));

        // Execution
        Optional<City> cityResult = cityService.findById(1L);

        // Assertions
        assert cityResult.isPresent();
    }

    @Test
    void findById_isNotPresent() {
        // Setup
        Mockito
                .when(cityService.findById(Mockito.anyLong()))
                .thenReturn(Optional.empty());

        // Execution
        Optional<City> cityResult = cityService.findById(1L);

        // Assertions
        assert cityResult.isEmpty();
    }

    @Test
    void delete() {
        // Create a City to delete
        City cityToDelete = new City();
        cityToDelete.setId(1L);
        cityToDelete.setName("Toronto");

        // Mock the delete operation
        Mockito.doNothing().when(cityService).delete(cityToDelete.getId());

        // Execution
        cityService.delete(cityToDelete.getId());

    }

    @Test
    void update() {
        // Setup
        Country canada = new Country();
        canada.setName("Canada");

        City cityToUpdate = new City();
        cityToUpdate.setId(3L);
        cityToUpdate.setName("Vancouver");
        cityToUpdate.setCountry(canada);

        // Mock the update operation
        Mockito.doNothing().when(cityService).update(cityToUpdate.getId());

        // Execution
        cityService.update(cityToUpdate.getId());
    }
}

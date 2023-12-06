package ca.vanier.customersapi.service;

import ca.vanier.addresses.entity.City;
import ca.vanier.addresses.entity.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class CityServiceImplTest {

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
	void update() {

		// setup
		Country canada = new Country();
		canada.setName("Canada");

		City city = new City();
		city.setId(2L);
		city.setName("Montreal");
		city.setCountry(canada);

		// moking the void data
		Mockito.doNothing().when(cityService).update(city.getId());

		// Execution
		cityService.update(city.getId());

		// Assertions
		Mockito.verify(cityService, Mockito.times(1)).update(city.getId());

	}
	@Test
	void update_isNotPresent() {
		// Setup
		Mockito.doNothing().when(cityService).update(Mockito.anyLong());

		// Execution
		cityService.update(1L);
		Optional<City> cityResult = cityService.findById(1L);

		// Assertions
		Mockito.verify(cityService, Mockito.times(1)).update(1L);
		assert cityResult.isEmpty();
	}

	@Test
	void delete() {

		// Setup
		Country canada = new Country();
		canada.setName("Canada");

		City city = new City();
		city.setId(2L);
		city.setName("Montreal");
		city.setCountry(canada);

		Mockito.doNothing().when(cityService).delete(city.getId());

		// Execution
		cityService.delete(city.getId());

		// Assertions
		Mockito.verify(cityService, Mockito.times(1)).delete(city.getId());

	}
}

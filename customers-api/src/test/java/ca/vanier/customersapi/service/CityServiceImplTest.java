package ca.vanier.customersapi.service;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.vanier.addresses.entity.City;
import ca.vanier.addresses.entity.Country;
//import ca.vanier.customersapi.repository.CityRepository;
//import ca.vanier.customersapi.repository.CountryRepository;


@ExtendWith(SpringExtension.class)
class CityServiceImplTest {
    /*@Mock
    CityRepository cityRepository;

    //@Mock
    CountryRepository countryRepository;

    //@InjectMocks*/
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
    void findById() {
        Country canada = new Country();
        canada.setName("canada");
        
        City cityToSave = new City();
        cityToSave.setId(1L);
        cityToSave.setName("montreal"); 
        cityToSave.setCountry(canada);

        Mockito.when( //when I use the save mthod of city service
            cityService.findById(1L)
        )       //then return the city result 
        .thenReturn(Optional.of(cityToSave));

        Mockito.when( //when I use the save mthod of city service
            cityService.findById(2L)
        )       //then return the city result 
        .thenReturn(Optional.empty());

        //Execution of our service layer
        //cityService.save(cityToSave);
        Optional<City> cityResult = cityService.findById(1L);
        Optional<City> cityResult2 = cityService.findById(2L);

        //Assertions - take the output of the execution and assert if its the output we're looking for
        assert cityResult.get().getId().equals(1L);
        assert cityResult.isPresent();
        assert cityResult2.isEmpty();
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
        //Setup
        Long cityId = 1L;

        //doNothing() because update() method has void return
        Mockito.doNothing().when(cityService).update(Mockito.anyLong());
        
        //Execution of our service layer
        cityService.update(cityId);

        //Assertions 
        //verify the method is invoked a fixed number of times
        Mockito.verify(cityService, Mockito.times(1)).update(cityId);
    }

    @Test
    void delete() {
        //Setup
        Long cityId = 1L;

        //doNothing() because update() method has void return
        Mockito.doNothing().when(cityService).delete(Mockito.anyLong());
        
        //Execution of our service layer
        cityService.delete(cityId);

        //Assertions 
        //verify the method is invoked a fixed number of times
        Mockito.verify(cityService, Mockito.times(1)).delete(cityId);
    }
}

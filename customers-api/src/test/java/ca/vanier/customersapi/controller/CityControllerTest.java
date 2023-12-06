package ca.vanier.customersapi.controller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import ca.vanier.addresses.entity.City;
import ca.vanier.addresses.entity.Country;
import ca.vanier.customersapi.service.CityService;

//static imports required for the payload
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @MockBean
    //this injects the specific class of CityServiceImpl
    CityService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testDelete() {

    }

    @Test
    void testFindById() throws Exception {
        //set up
        Country canada = new Country();
        canada.setName("Canada");

        City cityResult = new City();
        cityResult.setId(1L);
        cityResult.setName("Montreal");
        cityResult.setCountry(canada);

        Mockito
        .when(service.findById(Mockito.anyLong()))
        .thenReturn(Optional.of(cityResult));

        //Execute
        mockMvc.perform(
            get("/?id=1")).andDo(print())
        //Assert
            .andExpect(status().isFound());       
    }

    @Test
    void testGetCountryName() {

    }

    @Test
    void testSave() {

    }
}

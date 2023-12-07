package ca.vanier.customersapi.controller;

import ca.vanier.addresses.entity.City;
import ca.vanier.addresses.entity.Country;
import ca.vanier.customersapi.service.CityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CityControllerTest {

    @MockBean
    CityService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    void save() {
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void findById() throws Exception {
        // Setup
        Country canada = new Country();
        canada.setName("Canada");

        City cityResult = new City();
        cityResult.setId(2L);
        cityResult.setName("Montreal");
        cityResult.setCountry(canada);

        Mockito
                .when(service.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(cityResult));

        // Execute
        mockMvc.perform(
                get("/city/?id=1")).andDo(print())
                // Assert
                .andExpect(status().isFound());
    }

    @Test
    void delete() {
    }

    @Test
    void getCountryName() {
    }
}
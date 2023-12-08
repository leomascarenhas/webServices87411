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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	void save() throws Exception {

		// Setup
		Country canada = new Country();
		canada.setName("Canada");

		City cityResult = new City();
		cityResult.setId(2L);
		cityResult.setName("Montreal");
		cityResult.setCountry(canada);
		// Mocking the service save method
		Mockito.when(service.save(Mockito.any(City.class))).thenReturn(cityResult);

		// Execution and Assert
		mockMvc.perform(post("/city/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(cityResult))).andDo(print())
				.andExpect(status().isCreated());

//		Mockito.when(service.save(cityResult)).thenReturn(cityResult);
//		mockMvc.perform(post("/city/")).andDo(print())
//		// Assert
//		.andExpect(status().isCreated());

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

		Mockito.when(service.findById(Mockito.anyLong())).thenReturn(Optional.of(cityResult));

		// Execute
		mockMvc.perform(get("/city/?id=2")).andDo(print())
				// Assert
				.andExpect(status().isFound()).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Montreal"));
	}

	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
//	 @WithMockUser(username = "student", password = "password", roles = "USER")
	void deleteTest() throws Exception {

		// Setup
		Country canada = new Country();
		canada.setId(2L);
		canada.setName("Canada");

		City cityResult = new City();
		cityResult.setId(2L);
		cityResult.setName("Montreal");

		// execute
		Mockito.doNothing().when(service).delete(Mockito.anyLong());

		// Execution
		mockMvc.perform(delete("/city/?id=2")).andDo(print())
				// Assert
				.andExpect(status().isAccepted());

	}

	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	void getCountryNameTest() throws Exception {

		// Setup
		Country canada = new Country();
		canada.setId(2L);
		canada.setName("Canada");

		City cityResult = new City();
		cityResult.setId(2L);
		cityResult.setName("Montreal");
		cityResult.setCountry(canada);

		Mockito.when(service.findById(Mockito.anyLong())) 
				.thenReturn(Optional.of(cityResult));

		// Execute and Assert
		mockMvc.perform(get("/city/getCountry?id=2")).andDo(print()).andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.content().string("The country name of city %s is %sCanada"));

	}
}

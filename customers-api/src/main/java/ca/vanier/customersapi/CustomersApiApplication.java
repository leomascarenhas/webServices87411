package ca.vanier.customersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"ca.vanier.customersapi.entity",
		"ca.vanier.addresses.entity",
		"ca.vanier.customers.entity"})
@EnableAutoConfiguration
public class CustomersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApiApplication.class, args);
	}

}

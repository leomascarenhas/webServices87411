package ca.vanier.customersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CustomersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApiApplication.class, args);
	}

}

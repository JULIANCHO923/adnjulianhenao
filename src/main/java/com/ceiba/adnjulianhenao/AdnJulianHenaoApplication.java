package com.ceiba.adnjulianhenao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdnJulianHenaoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AdnJulianHenaoApplication.class, args);
	}
		
	/*
	@Bean
	public CommandLineRunner demo(IVehiculoRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new EntityVehiculo("Jack",  2,500));
			repository.save(new EntityVehiculo("Chloe", 1,0));
			repository.save(new EntityVehiculo("Kim", 1,0));
			repository.save(new EntityVehiculo("David", 1,0));
			repository.save(new EntityVehiculo("Michelle", 2,650));
			repository.save(new EntityVehiculo("julián",  2,200));
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (EntityVehiculo person : repository.findAll()) {
				log.info(person.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1L)
				.ifPresent(person -> {
					log.info("Person found with findById(1L):");
					log.info("--------------------------------");
					log.info(person.toString());
					log.info("");
				});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			//repository.findById((long) 1).forEach(bauer -> {
				//log.info(bauer.toString());
			//});			
			log.info("");
		};
	}
	*/
}

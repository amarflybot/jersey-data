package com.example.jerseydata;

import com.example.jerseydata.model.Address;
import com.example.jerseydata.model.Person;
import com.example.jerseydata.repo.AddressRepo;
import com.example.jerseydata.repo.PersonRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JerseyDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseyDataApplication.class, args);
	}

	//@Bean
	public ApplicationRunner applicationRunner(final PersonRepo personRepo,
											   final AddressRepo addressRepo) {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				Address india = addressRepo.save(new Address("India"));
				personRepo.save(new Person("Amar", india));

				Address lanka = addressRepo.save(new Address("SriLanka"));
				personRepo.save(new Person("Nagendra", lanka));
			}
		};
	}
}

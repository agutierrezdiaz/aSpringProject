package org.a.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ASpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ASpringProjectApplication.class, args);
	}

}

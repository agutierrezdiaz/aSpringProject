package org.a.demo;

import org.a.demo.config.properties.PrototypeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(PrototypeProperties.class)
public class ASpringProjectApplication implements CommandLineRunner, WebMvcConfigurer {

	@Autowired
	private PrototypeProperties prototypeProperties;

	public static void main(String[] args) {
		SpringApplication.run(ASpringProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(prototypeProperties);
	}

}

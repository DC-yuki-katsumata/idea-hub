package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {
	public static void main(String[] args) {
		// Load environment variables from .env file
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		System.setProperty("JAWSDB_URL", dotenv.get("JAWSDB_URL"));
		System.setProperty("SPRING_DATASOURCE_DRIVER_CLASS_NAME", dotenv.get("SPRING_DATASOURCE_DRIVER_CLASS_NAME"));
		System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
		System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
		System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
		System.setProperty("SPRING_JPA_HIBERNATE_DDL_AUTO", dotenv.get("SPRING_JPA_HIBERNATE_DDL_AUTO"));
		System.setProperty("SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT",
				dotenv.get("SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT"));
		SpringApplication.run(SampleApplication.class, args);
	}

}

package com.moviebooking.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class MovieFixer {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

        // Set as system properties
        System.setProperty("DATASOURCE_URL", dotenv.get("DATASOURCE_URL"));
        System.setProperty("DATASOURCE_USERNAME", dotenv.get("DATASOURCE_USERNAME"));
        System.setProperty("DATASOURCE_PASSWORD", dotenv.get("DATASOURCE_PASSWORD"));
        System.setProperty("FRONTEND_URL", dotenv.get("FRONTEND_URL"));
		SpringApplication.run(MovieFixer.class, args);
	}

}

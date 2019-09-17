package com.ineat.poc.ingredient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan(basePackages = "com.ineat.poc.models")
public class IngredientApplication {
	public static void main(String[] args) {
		SpringApplication.run(IngredientApplication.class, args);
	}
}

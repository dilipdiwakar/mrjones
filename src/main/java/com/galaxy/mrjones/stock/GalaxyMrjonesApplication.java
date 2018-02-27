package com.galaxy.mrjones.stock;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GalaxyMrjonesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(GalaxyMrjonesApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(GalaxyMrjonesApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
	}
}

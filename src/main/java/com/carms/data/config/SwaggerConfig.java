package com.carms.data.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Car Management System API").version("1.0")
				.description("API documentation for the Car Management System")
				.contact(new Contact().name("Support").email("support@carms.com")));
	}

	@Bean
	public GroupedOpenApi carApi() {
		return GroupedOpenApi.builder().group("car-api").pathsToMatch("/api/cars/**").build();
	}
}

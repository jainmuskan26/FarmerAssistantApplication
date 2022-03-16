package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class FarmerAssistProgramWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerAssistProgramWebApplication.class, args);
		
		System.out.println("WELCOME FARMING ASSISTANT SYSTEM");
	}
	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(RequestHandlerSelectors.basePackage("com")).build();
	}
	
	//http://localhost:8080/swagger-ui/index.html
}

package com.example.springSecurity.sequrity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SequrityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SequrityApplication.class, args);
	}

}

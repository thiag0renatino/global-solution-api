package com.fiap.global_solution_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API Global Solution",
				version = "1.0",
				description = "Documentação da API Global Solution - Solução para Eventos Extremos"
		)
)
public class GlobalSolutionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalSolutionApiApplication.class, args);
	}

}

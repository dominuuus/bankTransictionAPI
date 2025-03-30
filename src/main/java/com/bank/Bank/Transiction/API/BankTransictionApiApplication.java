package com.bank.Bank.Transiction.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	info = @Info(title = "Bank Transaction API", version = "1.0", description = "API para realização de transação bancária entre usuários")
)

@SpringBootApplication
public class BankTransictionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTransictionApiApplication.class, args);
	}

}

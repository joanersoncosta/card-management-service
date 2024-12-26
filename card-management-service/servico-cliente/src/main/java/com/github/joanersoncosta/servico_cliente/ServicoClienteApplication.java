package com.github.joanersoncosta.servico_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/teste")
public class ServicoClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoClienteApplication.class, args);
	}

	@GetMapping("/home")
	public String testeHome() {
		return "Teste Home";
	}
}

package com.github.joanersoncosta.servico_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@RestController
@RequestMapping("/teste")
@Log4j2
public class ServicoClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoClienteApplication.class, args);
	}

	@GetMapping("/home")
	public String testeHome() {
		log.info("[start] ServicoClienteApplication - testeHome");
		return "Teste Home";
	}
}

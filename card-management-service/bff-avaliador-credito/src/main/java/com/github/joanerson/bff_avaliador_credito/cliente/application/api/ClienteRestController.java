package com.github.joanerson.bff_avaliador_credito.cliente.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.bff_avaliador_credito.cliente.application.service.ClienteService;
import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
	private final ClienteService clienteService;

	@Override
	public Cliente buscaClientePorCpf(String cpf) {
		log.info("[start] ClienteRestController - buscaClientePorCpf");
		Cliente clienteResponse = clienteService.buscaClientePorCpf(cpf);
		log.info("[finish] ClienteRestController - buscaClientePorCpf");
		return clienteResponse;
	}
}
package com.github.joanersoncosta.servico_cliente.cliente.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteCriadoResponse;
import com.github.joanersoncosta.servico_cliente.cliente.application.service.ClienteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
	private final ClienteService clienteService;
	
	@Override
	public ClienteCriadoResponse criaNovoCliente(ClienteNovoRequest clienteRequest) {
		log.info("[start] ClienteRestController - criaNovoCliente");
		ClienteCriadoResponse clienteResponse = clienteService.criaNovoCliente(clienteRequest);
		log.info("[finish] ClienteRestController - criaNovoCliente");
		return clienteResponse;
	}

}
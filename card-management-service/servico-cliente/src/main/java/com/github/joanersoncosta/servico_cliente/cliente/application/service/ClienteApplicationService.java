package com.github.joanersoncosta.servico_cliente.cliente.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteCriadoResponse;
import com.github.joanersoncosta.servico_cliente.cliente.application.repository.ClienteRepository;
import com.github.joanersoncosta.servico_cliente.cliente.domain.Cliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;
	
	@Override
	public ClienteCriadoResponse criaNovoCliente(ClienteNovoRequest clienteRequest) {
		log.info("[start] ClienteRestController - criaNovoCliente");
		log.debug("[clienteRequest] {}", clienteRequest.toString());
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finish] ClienteRestController - criaNovoCliente");
		return new ClienteCriadoResponse(cliente);
	}

}
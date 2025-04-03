package com.github.joanerson.bff_avaliador_credito.cliente.application.service;

import org.springframework.stereotype.Service;

import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;
import com.github.joanerson.bff_avaliador_credito.cliente.infra.cliente.ClienteInfraService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteInfraService clienteInfraService;

	@Override
	public Cliente buscaClientePorCpf(String cpf) {
        log.info("[start] ClienteApplicationService - buscaClientePorCpf");
		Cliente cliente = clienteInfraService.buscaClientePorCpf(cpf);
        log.debug("[finish] ClienteApplicationService - buscaClientePorCpf");
		return cliente;
	}
}
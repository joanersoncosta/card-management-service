package com.github.joanersoncosta.servico_cliente.cliente.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.servico_cliente.cliente.application.repository.ClienteRepository;
import com.github.joanersoncosta.servico_cliente.cliente.domain.Cliente;
import com.github.joanersoncosta.servico_cliente.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteInfraRepository implements ClienteRepository {
	private final ClienteSpringDataJpaRepository clienteSpringRepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[start] ClienteInfraRepository - save");
		try {
			clienteSpringRepository.save(cliente);
		} catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.CONFLICT, "Já existe um cliente com este email.");
		}
		log.info("[finish] ClienteInfraRepository - save");
		return cliente;
	}

}
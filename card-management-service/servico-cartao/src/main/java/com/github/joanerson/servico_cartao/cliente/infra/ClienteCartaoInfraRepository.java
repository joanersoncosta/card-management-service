package com.github.joanerson.servico_cartao.cliente.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.joanerson.servico_cartao.cliente.application.repository.ClienteCartaoRepository;
import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteCartaoInfraRepository implements ClienteCartaoRepository {
	private final ClienteCartaoSpringDataJpaRepository clienteCartaoSpringDataJpaRepository;

	@Override
	public List<ClienteCartao> buscaCartaoPorCpf(String cpf) {
		log.info("[start] ClienteCartaoInfraRepository - buscaCartaoPorCpf");
		List<ClienteCartao> clienteCartao = clienteCartaoSpringDataJpaRepository.findByCpf(cpf);
		log.info("[finish] ClienteCartaoInfraRepository - buscaCartaoPorCpf");
		return clienteCartao;
	}

}
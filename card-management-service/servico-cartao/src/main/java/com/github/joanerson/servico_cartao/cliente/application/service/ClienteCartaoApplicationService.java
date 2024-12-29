package com.github.joanerson.servico_cartao.cliente.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.joanerson.servico_cartao.cliente.application.repository.ClienteCartaoRepository;
import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteCartaoApplicationService implements ClienteCartaoService {
	private final ClienteCartaoRepository clienteCartaoRepository;
	
	@Override
	public Optional<ClienteCartao> buscaCartaoPorCpf(String cpf) {
		log.info("[start] ClienteCartaoApplicationService - buscaCartaoPorCpf");
		Optional<ClienteCartao> clienteCartao = clienteCartaoRepository.buscaCartaoPorCpf(cpf);
		log.info("[finish] ClienteCartaoApplicationService - buscaCartaoPorCpf");
		return clienteCartao;
	}
}
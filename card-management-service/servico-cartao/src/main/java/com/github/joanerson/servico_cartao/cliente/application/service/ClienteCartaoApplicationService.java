package com.github.joanerson.servico_cartao.cliente.application.service;

import java.util.List;

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
	public List<ClienteCartao> buscaCartaoPorCpf(String cpf) {
		log.info("[start] ClienteCartaoApplicationService - buscaCartaoPorCpf");
		List<ClienteCartao> clienteCartao = clienteCartaoRepository.buscaCartaoPorCpf(cpf);
		log.info("[finish] ClienteCartaoApplicationService - buscaCartaoPorCpf");
		return clienteCartao;
	}
}
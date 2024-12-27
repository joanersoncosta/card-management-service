package com.github.joanerson.servico_cartao.cartao.application.service;

import org.springframework.stereotype.Service;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.repository.CartaoRepository;
import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartaoApplicationService implements CartaoService {
	private final CartaoRepository cartaoRepository;

	@Override
	public void criaNovoCartao(CartaoNovoRequest cartaoRequest) {
		log.info("[start] CartaoApplicationService - criaNovoCartao");
		log.debug("[clienteRequest] {}", cartaoRequest.toString());
		cartaoRepository.salva(new Cartao(cartaoRequest));
		log.info("[finish] CartaoApplicationService - criaNovoCartao");
	}

}

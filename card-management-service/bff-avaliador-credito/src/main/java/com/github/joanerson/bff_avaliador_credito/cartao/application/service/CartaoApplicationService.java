package com.github.joanerson.bff_avaliador_credito.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;
import com.github.joanerson.bff_avaliador_credito.cartao.infra.CartaoDetalhadoResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartaoApplicationService implements CartaoService{

	@Override
	public List<CartaoResponse> buscaCartaoPorRenda(BigDecimal renda) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorRenda");
		log.debug("[renda] {}", renda);
		log.debug("[finish] CartaoApplicationService - buscaCartaoPorRenda");
		return null;
	}

	@Override
	public List<ClienteCartao> buscaCartaoPorCpf(String cpf) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorCpf");
		log.debug("[finish] CartaoApplicationService - buscaCartaoPorCpf");
		return null;
	}

	@Override
	public CartaoDetalhadoResponse buscaCartaoPorId(UUID idCartao) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorId");
		log.debug("[finish] CartaoApplicationService - buscaCartaoPorId");
		return null;
	}
}
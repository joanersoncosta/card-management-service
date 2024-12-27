package com.github.joanerson.servico_cartao.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
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

	@Override
	public List<CartaoResponse> buscaCartoesRendaAte(Long renda) {
		log.info("[start] CartaoApplicationService - buscaCartoesRendaAte");
		BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
		List<Cartao> cartoes = cartaoRepository.CartoesRendaMenorIgual(rendaBigDecimal);
		log.info("[finish] CartaoApplicationService - buscaCartoesRendaAte");
		return CartaoResponse.converte(cartoes);
	}

}

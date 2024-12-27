package com.github.joanerson.servico_cartao.cartao.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.servico_cartao.cartao.application.service.CartaoService;
import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CartaoRestController implements CartaoAPI {
	private final CartaoService cartaoService;
	
	@Override
	public void postNovoCartao(CartaoNovoRequest cartaoRequest) {
		log.info("[start] CartaoRestController - postNovoCartao");
		cartaoService.criaNovoCartao(cartaoRequest);
		log.info("[finish] CartaoRestController - postNovoCartao");

	}
	
	@Override
	public List<Cartao> getCartoesRendaAte(Long renda) {
		return null;
	}

}
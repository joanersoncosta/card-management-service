package com.github.joanerson.bff_avaliador_credito.cartao.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.application.api.response.CartaoDetalhadoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.application.service.CartaoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CartaoRestController implements CartaoAPI {
	private final CartaoService cartaoService;

	@Override
	public CartaoDetalhadoResponse getCartaoPorId(UUID idCartao) {
		log.info("[start] CartaoRestController - getCartaoPorId");
		CartaoDetalhadoResponse response= cartaoService.buscaCartaoPorId(idCartao);
		log.info("[finish] CartaoRestController - getCartaoPorId");
		return response;
	}

	@Override
	public List<CartaoResponse> getListaCartoes() {
		log.info("[start] CartaoRestController - getListaCartoes");
		List<CartaoResponse> response= cartaoService.buscaCartoes();
		log.info("[finish] CartaoRestController - getListaCartoes");
		return response;
	}
}
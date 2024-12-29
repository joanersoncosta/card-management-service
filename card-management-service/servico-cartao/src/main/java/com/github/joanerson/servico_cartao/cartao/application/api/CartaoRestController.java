package com.github.joanerson.servico_cartao.cartao.application.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.service.CartaoService;

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
	public List<CartaoResponse> getCartoesRendaAte(Long renda) {
		log.info("[start] CartaoRestController - getCartoesRendaAte");
		List<CartaoResponse> response= cartaoService.buscaCartoesRendaAte(renda);
		log.info("[finish] CartaoRestController - getCartoesRendaAte");
		return response;
	}

	@Override
	public Optional<CartaoResponse> getCartoesPorClienteResponse(String cpf) {
		log.info("[start] CartaoRestController - getCartoesPorClienteResponse");
		Optional<CartaoResponse> response= cartaoService.buscaCartoesPorCliente(cpf);
		log.info("[finish] CartaoRestController - getCartoesPorClienteResponse");
		return response;
	}

}
package com.github.joanerson.servico_cartao.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.api.response.ClienteCartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.repository.CartaoRepository;
import com.github.joanerson.servico_cartao.cartao.domain.Cartao;
import com.github.joanerson.servico_cartao.cliente.application.service.ClienteCartaoService;
import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartaoApplicationService implements CartaoService {
	private final CartaoRepository cartaoRepository;
	private final ClienteCartaoService clienteCartaoService;
	
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

	@Override
	public List<ClienteCartaoResponse> buscaCartaoPorCpf(String cpf) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorCpf");
		List<ClienteCartao> clienteResponse = clienteCartaoService.buscaCartaoPorCpf(cpf);
		log.info("[finish] CartaoApplicationService - buscaCartaoPorCpf");
		return ClienteCartaoResponse.converte(clienteResponse);
	}

}
package com.github.joanerson.servico_cartao.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoDetalhadoResponse;
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
	public List<CartaoResponse> buscaCartoesRendaAte(BigDecimal renda) {
		log.info("[start] CartaoApplicationService - buscaCartoesRendaAte");
		List<Cartao> cartoes = cartaoRepository.CartoesRendaMenorIgual(renda);
		log.info("[finish] CartaoApplicationService - buscaCartoesRendaAte");
		return CartaoResponse.converte(cartoes);
	}

	@Override
	public List<ClienteCartaoResponse> buscaCartaoPorCpf(String cpf) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorCpf");
		List<ClienteCartao> clienteCartao = clienteCartaoService.buscaCartaoPorCpf(cpf);
		if (!clienteCartao.isEmpty()) {
			Cartao cartao = cartaoRepository.buscaCartaoPorId(clienteCartao.get(0).getIdCartao());
			return List.of(ClienteCartaoResponse.converte(cartao, clienteCartao.get(0).getLimite()));
		} else {
			return List.of();
		}
	}

	@Override
	public CartaoDetalhadoResponse buscaCartaoPorId(UUID idCartao) {
		log.info("[start] CartaoApplicationService - buscaCartaoPorId");
		Cartao cartao = cartaoRepository.buscaCartaoPorId(idCartao);
		log.info("[finish] CartaoApplicationService - buscaCartaoPorId");
		return CartaoDetalhadoResponse.converte(cartao);
	}

	@Override
	public List<CartaoResponse> buscaCartoes() {
		log.info("[start] CartaoApplicationService - buscaCartoes");
		List<Cartao> cartoes = cartaoRepository.buscaCartoes();
		log.info("[finish] CartaoApplicationService - buscaCartoes");
		return CartaoResponse.converte(cartoes);
	}
}
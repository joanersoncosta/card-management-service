package com.github.joanerson.servico_cartao.cartao.application.service;

import java.util.List;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;

public interface CartaoService {
	void criaNovoCartao(CartaoNovoRequest cartaoRequest);
	List<CartaoResponse> buscaCartoesRendaAte(Long renda);
}
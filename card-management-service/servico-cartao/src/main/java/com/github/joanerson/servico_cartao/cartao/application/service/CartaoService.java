package com.github.joanerson.servico_cartao.cartao.application.service;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;

public interface CartaoService {
	void criaNovoCartao(CartaoNovoRequest cartaoRequest);

}
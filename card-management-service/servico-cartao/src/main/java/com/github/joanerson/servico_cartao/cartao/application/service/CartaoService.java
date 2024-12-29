package com.github.joanerson.servico_cartao.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.api.response.ClienteCartaoResponse;

public interface CartaoService {
	void criaNovoCartao(CartaoNovoRequest cartaoRequest);
	List<CartaoResponse> buscaCartoesRendaAte(BigDecimal renda);
	List<ClienteCartaoResponse> buscaCartaoPorCpf(String cpf);
}
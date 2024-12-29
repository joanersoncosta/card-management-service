package com.github.joanerson.servico_cartao.cartao.application.service;

import java.util.List;
import java.util.Optional;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.api.response.ClienteCartaoResponse;

public interface CartaoService {
	void criaNovoCartao(CartaoNovoRequest cartaoRequest);
	List<CartaoResponse> buscaCartoesRendaAte(Long renda);
	Optional<ClienteCartaoResponse> buscaCartaoPorCpf(String cpf);
}
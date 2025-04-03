package com.github.joanerson.bff_avaliador_credito.cartao.application.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;
import com.github.joanerson.bff_avaliador_credito.cartao.infra.CartaoDetalhadoResponse;

public interface CartaoService {
	List<CartaoResponse> buscaCartaoPorRenda(BigDecimal renda);
	List<ClienteCartao> buscaCartaoPorCpf(String cpf);
	CartaoDetalhadoResponse buscaCartaoPorId(UUID idCartao);
}
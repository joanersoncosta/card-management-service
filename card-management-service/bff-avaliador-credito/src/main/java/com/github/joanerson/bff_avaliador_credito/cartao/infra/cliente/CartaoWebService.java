package com.github.joanerson.bff_avaliador_credito.cartao.infra.cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.application.api.response.CartaoDetalhadoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;

public interface CartaoWebService {
	CartaoDetalhadoResponse buscaCartaoPorId(UUID idCartao);
	List<ClienteCartao> buscaCartaoDoClientePorCpf(String cpf);
	List<CartaoResponse> buscaCartaoPorRenda(BigDecimal renda);
}
package com.github.joanerson.bff_avaliador_credito.avaliador.application.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.CartaoAprovadoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.DadosSolicitacaoEmissaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.ProtocoloSolicitacaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;

public interface AvaliadorCreditoService {
	SituacaoCliente consultaSituacaoCliente(String cpf);
	ProtocoloSolicitacaoCartao solicitarCartao(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao);
	List<CartaoAprovadoResponse> realizaAvaliacaoCliente(String cpf, BigDecimal renda);
}
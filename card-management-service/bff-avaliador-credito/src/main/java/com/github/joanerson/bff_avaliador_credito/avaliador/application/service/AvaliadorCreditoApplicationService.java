package com.github.joanerson.bff_avaliador_credito.avaliador.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.CartaoAprovadoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.DadosSolicitacaoEmissaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.ProtocoloSolicitacaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AvaliadorCreditoApplicationService implements AvaliadorCreditoService {

	@Override
	public List<CartaoAprovadoResponse> realizaAvaliacaoCliente(String cpf, BigDecimal renda) {
		log.info("[start] AvaliadorCreditoApplicationService - realizaAvaliacaoCliente");
		log.info("[renda] {}", renda);
		log.info("[finish] AvaliadorCreditoApplicationService - realizaAvaliacaoCliente");
		return null;
	}
	
	@Override
	public SituacaoCliente consultaSituacaoCliente(String cpf) {
		log.info("[start] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		log.info("[finish] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		return null;
	}

	@Override
	public ProtocoloSolicitacaoCartao solicitarCartao(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {
		log.info("[start] AvaliadorCreditoApplicationService - solicitarCartao");
		log.debug("[dadosSolicitacaoEmissaoCartao] {}", dadosSolicitacaoEmissaoCartao.toString());
		log.info("[finish] AvaliadorCreditoApplicationService - solicitarCartao");
		return null;
	}
}
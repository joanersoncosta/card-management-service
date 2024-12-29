package com.github.joanerson.bff_avaliador_credito.avaliador.application.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.CartaoAprovadoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.DadosSolicitacaoEmissaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.ProtocoloSolicitacaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.service.AvaliadorCreditoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AvaliadorCreditoRestController implements AvaliadorCreditoAPI {
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	@Override
	public String getHome() {
		log.info("[start] AvaliadorCreditoRestController - getHome");
		return "API Avaliador de Credito";
	}

	@Override
	public List<CartaoAprovadoResponse> getRealizaAvaliacaoCliente(String cpf, BigDecimal renda) {
		log.info("[start] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		List<CartaoAprovadoResponse> cartaoAprovadoResponse = avaliadorCreditoService.realizaAvaliacaoCliente(cpf, renda);
		log.info("[finish] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		return cartaoAprovadoResponse;
	}
	
	@Override
	public SituacaoCliente getConsultaSituacaoCliente(String cpf) {
		log.info("[start] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		SituacaoCliente situacaoCliente = avaliadorCreditoService.consultaSituacaoCliente(cpf);
		log.info("[finish] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		return situacaoCliente;
	}

	@Override
	public ProtocoloSolicitacaoCartao postSolicitarCartao(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {
		log.info("[start] AvaliadorCreditoRestController - postSolicitarCartao");
		ProtocoloSolicitacaoCartao protocolo = avaliadorCreditoService.solicitarCartao(dadosSolicitacaoEmissaoCartao);
		log.info("[finish] AvaliadorCreditoRestController - postSolicitarCartao");
		return protocolo;
	}

}
package com.github.joanerson.bff_avaliador_credito.avaliador.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AvaliadorCreditoRestController implements AvaliadorCreditoAPI {

	@Override
	public String getHome() {
		log.info("[start] AvaliadorCreditoRestController - getHome");
		return "API Avaliador de Credito";
	}

	@Override
	public SituacaoCliente getConsultaSituacaoCliente(String cpf) {
		log.info("[start] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		log.info("[finish] AvaliadorCreditoRestController - getConsultaSituacaoCliente");
		return null;
	}

}
package com.github.joanerson.bff_avaliador_credito.avaliador.application.service;

import org.springframework.stereotype.Service;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AvaliadorCreditoApplicationService implements AvaliadorCreditoService {

	@Override
	public SituacaoCliente consultaSituacaoCliente(String cpf) {
		log.info("[start] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		log.info("[finish] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		return null;
	}

}
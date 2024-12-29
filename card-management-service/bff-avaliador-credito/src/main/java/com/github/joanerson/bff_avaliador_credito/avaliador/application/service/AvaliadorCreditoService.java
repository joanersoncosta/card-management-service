package com.github.joanerson.bff_avaliador_credito.avaliador.application.service;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;

public interface AvaliadorCreditoService {
	SituacaoCliente consultaSituacaoCliente(String cpf);
}
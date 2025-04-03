package com.github.joanerson.bff_avaliador_credito.cliente.application.service;

import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

public interface ClienteService {
	Cliente buscaClientePorCpf(String cpf);
}
package com.github.joanerson.bff_avaliador_credito.cliente.infra.cliente;

import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

public interface ClienteInfraService {
	Cliente buscaClientePorCpf(String cpf);

}

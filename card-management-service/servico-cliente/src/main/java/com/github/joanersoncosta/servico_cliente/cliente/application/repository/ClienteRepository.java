package com.github.joanersoncosta.servico_cliente.cliente.application.repository;

import com.github.joanersoncosta.servico_cliente.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);

}
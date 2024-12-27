package com.github.joanersoncosta.servico_cliente.cliente.application.service;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteCriadoResponse;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteResponse;

public interface ClienteService {
	ClienteCriadoResponse criaNovoCliente(ClienteNovoRequest clienteRequest);
	ClienteResponse buscaClientePorCpf(String cpf);

}
package com.github.joanersoncosta.servico_cliente.cliente.application.service;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteCriadoResponse;

public interface ClienteService {
	ClienteCriadoResponse criaNovoCliente(ClienteNovoRequest clienteRequest);

}
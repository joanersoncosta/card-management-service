package com.github.joanersoncosta.servico_cliente.cliente.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.servico_cliente.cliente.domain.Cliente;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteCriadoResponse{
	private UUID idCliente;
	
	public ClienteCriadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
	}

}
package com.github.joanersoncosta.servico_cliente.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Cliente {
	private UUID idCliente;
	private String nome;
	private String cpf;
	private String email;
	private Integer idade;
    private LocalDateTime dataCadastro;

	public Cliente(ClienteNovoRequest clienteRequest) {
        this.nome = clienteRequest.nome();
        this.cpf = clienteRequest.cpf();
        this.email = clienteRequest.email();
        this.idade = clienteRequest.idade();
        this.dataCadastro = LocalDateTime.now();
    }
}
package com.github.joanersoncosta.servico_cliente.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

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

    public Cliente(UUID idCliente, String nome, String cpf, String email, Integer idade, LocalDateTime dataCadastro) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
    }
}
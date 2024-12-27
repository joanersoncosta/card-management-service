package com.github.joanersoncosta.servico_cliente.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "cliente", uniqueConstraints = {@UniqueConstraint(columnNames = "cpf"), @UniqueConstraint(columnNames = "email")})
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_cliente")
	private UUID idCliente;
    @Column(name = "nome")
	private String nome;
    @Column(name = "cpf", nullable = false, unique = true)
	private String cpf;
    @Column(name = "email")
	private String email;
    @Column(name = "idade")
	private Integer idade;
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

	public Cliente(ClienteNovoRequest clienteRequest) {
        this.nome = clienteRequest.nome();
        this.cpf = clienteRequest.cpf();
        this.email = clienteRequest.email();
        this.idade = clienteRequest.idade();
        this.dataCadastro = LocalDateTime.now();
    }
}
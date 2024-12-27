package com.github.joanerson.servico_cartao.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Cartao {
	private UUID idCartao;
	private String nome;
	private CartaoBandeira bandeira;
	private BigDecimal renda;
	private BigDecimal limiteBasico;
	
	public Cartao(CartaoNovoRequest cartaoRequest) {
		this.nome = cartaoRequest.nome();
		this.bandeira = cartaoRequest.bandeira();
		this.renda = cartaoRequest.renda();
		this.limiteBasico = cartaoRequest.limite();
	}
}
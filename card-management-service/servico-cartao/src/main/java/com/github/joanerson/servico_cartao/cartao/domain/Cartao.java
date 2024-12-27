package com.github.joanerson.servico_cartao.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "cartao")
public class Cartao {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_cartao")
	private UUID idCartao;
    @Column(name = "nome")
	private String nome;
	@Enumerated(EnumType.STRING)
    @Column(name = "bandeira")
	private CartaoBandeira bandeira;
    @Column(name = "renda")
	private BigDecimal renda;
    @Column(name = "limite_basico")
	private BigDecimal limiteBasico;
	
	public Cartao(CartaoNovoRequest cartaoRequest) {
		this.nome = cartaoRequest.nome();
		this.bandeira = cartaoRequest.bandeira();
		this.renda = cartaoRequest.renda();
		this.limiteBasico = cartaoRequest.limite();
	}
}
package com.github.joanerson.servico_cartao.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.github.joanerson.servico_cartao.cartao.application.api.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.handler.APIException;

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
		this.bandeira = retornaBandeira(cartaoRequest.bandeira());
		this.renda = cartaoRequest.renda();
		this.limiteBasico = cartaoRequest.limite();
	}
	
	private CartaoBandeira retornaBandeira(String bandeira) {
		return CartaoBandeira.validaBandeira(bandeira)
	            .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Bandeira inválida, digite novamente."));
	}
}
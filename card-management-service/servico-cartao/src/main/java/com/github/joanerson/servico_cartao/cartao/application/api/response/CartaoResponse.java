package com.github.joanerson.servico_cartao.cartao.application.api.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.joanerson.servico_cartao.cartao.domain.Cartao;
import com.github.joanerson.servico_cartao.cartao.domain.CartaoBandeira;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartaoResponse {
	private UUID idCartao;
	private String nome;
	private CartaoBandeira bandeira;
	private BigDecimal renda;
	private BigDecimal limiteBasico;
	
	public CartaoResponse(Cartao cartao) {
		this.idCartao = cartao.getIdCartao();
		this.nome = cartao.getNome();
		this.bandeira = cartao.getBandeira();
		this.renda = cartao.getRenda();
		this.limiteBasico = cartao.getLimiteBasico();
	}
	
	public static List<CartaoResponse> converte(List<Cartao> cartoes) {
		return null;
	}
}
package com.github.joanerson.servico_cartao.cartao.application.api.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.github.joanerson.servico_cartao.cartao.domain.Cartao;
import com.github.joanerson.servico_cartao.cartao.domain.CartaoBandeira;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "Informações detalhadas sobre o cartão de crédito")
public class CartaoResponse {

    @Schema(description = "Identificador único do cartão", example = "b7234e19-65b1-42d0-9d23-f82613f7d29c")
    private UUID idCartao;

    @Schema(description = "Nome do cartão", example = "Cartão 01")
    private String nome;

    @Schema(description = "Bandeira do cartão, como VISA, MasterCard, etc.", example = "VISA")
    private CartaoBandeira bandeira;

    @Schema(description = "Renda mensal do titular do cartão", example = "8000.00")
    private BigDecimal renda;

    @Schema(description = "Limite básico de crédito do cartão", example = "3000.00")
    private BigDecimal limiteBasico;
	
	public CartaoResponse(Cartao cartao) {
		this.idCartao = cartao.getIdCartao();
		this.nome = cartao.getNome();
		this.bandeira = cartao.getBandeira();
		this.renda = cartao.getRenda();
		this.limiteBasico = cartao.getLimiteBasico();
	}
	
	public static List<CartaoResponse> converte(List<Cartao> cartoes) {
		return cartoes.stream()
				.map(CartaoResponse::new)
				.collect(Collectors.toList());
	}
}
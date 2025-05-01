package com.github.joanerson.bff_avaliador_credito.cartao.application.api.response;

import java.util.UUID;

import com.github.joanerson.bff_avaliador_credito.cartao.domain.Cartao;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.CartaoBandeira;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "Informações detalhadas sobre o cartão de crédito")
public class CartaoDetalhadoResponse {

    @Schema(description = "Identificador único do cartão", example = "b7234e19-65b1-42d0-9d23-f82613f7d29c")
    private UUID idCartao;

    @Schema(description = "Nome do cartão", example = "Cartão 01")
    private String nome;

    @Schema(description = "Bandeira do cartão, como VISA, MasterCard, etc.", example = "VISA")
    private CartaoBandeira bandeira;
    
	public CartaoDetalhadoResponse(Cartao cartao) {
		this.idCartao = cartao.getIdCartao();
		this.nome = cartao.getNome();
		this.bandeira = cartao.getBandeira();
	}

	public static CartaoDetalhadoResponse converte(Cartao cartao) {
		return new CartaoDetalhadoResponse(cartao);
	}
}
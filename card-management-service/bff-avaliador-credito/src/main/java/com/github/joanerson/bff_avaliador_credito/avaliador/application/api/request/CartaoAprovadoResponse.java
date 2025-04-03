package com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request;

import java.math.BigDecimal;
import java.util.List;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.CartaoBandeira;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Informações detalhadas sobre o cartão")
public record CartaoAprovadoResponse(@Schema(description = "Nome do cartão", example = "Cartão 01") String nome,
		@Schema(description = "Bandeira do cartão, como VISA, MasterCard, etc.", example = "VISA") CartaoBandeira bandeira,
		@Schema(description = "Limite básico de crédito do cartão", example = "3000.00") BigDecimal limiteBasico) {

    public CartaoAprovadoResponse(CartaoResponse cartao) {
        this(cartao.getNome(), cartao.getBandeira(), cartao.getLimiteBasico());
    }

    public static List<CartaoAprovadoResponse> converte(List<CartaoResponse> cartoes) {
        return cartoes.stream()
                      .map(CartaoAprovadoResponse::new)
                      .toList();
    }
}
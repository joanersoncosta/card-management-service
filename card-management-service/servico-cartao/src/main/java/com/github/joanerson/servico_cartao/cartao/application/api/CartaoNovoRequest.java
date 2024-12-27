package com.github.joanerson.servico_cartao.cartao.application.api;

import java.math.BigDecimal;

import com.github.joanerson.servico_cartao.cartao.domain.CartaoBandeira;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Informações para a criação de um novo cartão")
public record CartaoNovoRequest(
		@Schema(description = "Nome do titular do cartão", example = "João da Silva") @NotBlank(message = "Campo nome não pode estar em branco.") 
		String nome,
		@Schema(description = "Bandeira do cartão, como Visa, MasterCard, etc.", example = "{VISA, MASTERCARD, AMEX, ELO, HIPERCARD}")
		@NotNull(message = "Campo bandeira não pode estar nulo.") 
		CartaoBandeira bandeira,
		@Schema(description = "Renda mensal do titular", example = "5000.00") @NotNull(message = "Campo renda não pode ser nulo.") 
		BigDecimal renda,
		@Schema(description = "Limite de crédito solicitado", example = "2000.00") @NotNull(message = "Campo limite não pode ser nulo.") 
		BigDecimal limite) {
}
package com.github.joanerson.bff_avaliador_credito.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteCartao {
    @Schema(description = "Identificador único do cartão", example = "b7234e19-65b1-42d0-9d23-f82613f7d29c")
    private UUID idCartao;

    @Schema(description = "Nome do cartão", example = "Cartão 01")
    private String nome;

    @Schema(description = "Bandeira do cartão, como VISA, MasterCard, etc.", example = "VISA")
    private CartaoBandeira bandeira;

    @Schema(description = "Renda mensal do titular do cartão", example = "8000.00")
    private BigDecimal renda;

    @Schema(description = "Limite básico de crédito do cartão", example = "3000.00")
    private BigDecimal limite;
}
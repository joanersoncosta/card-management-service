package com.github.joanerson.servico_cartao.cartao.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Enum que representa as bandeiras de cartão.")
public enum CartaoBandeira {
    @Schema(description = "Visa - Bandeira do cartão Visa")
    VISA,
    @Schema(description = "MasterCard - Bandeira do cartão MasterCard")
    MASTERCARD,
}
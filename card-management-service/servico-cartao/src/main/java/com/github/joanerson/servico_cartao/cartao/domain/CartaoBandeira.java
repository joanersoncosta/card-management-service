package com.github.joanerson.servico_cartao.cartao.domain;

import java.util.Arrays;
import java.util.Optional;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Enum que representa as bandeiras de cartão.")
public enum CartaoBandeira {
    @Schema(description = "Visa - Bandeira do cartão Visa")
    VISA("VISA"),
    @Schema(description = "MasterCard - Bandeira do cartão MasterCard")
    MASTERCARD("MASTERCARD"),
    @Schema(description = "Elo - Bandeira do cartão Elo")
    ELO("ELO");
    
    private String bandeira;

	private CartaoBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
    
	public static Optional<CartaoBandeira> validaBandeira(String bandeira) {
		return Arrays.stream(values()).filter(valorCorrespondente -> valorCorrespondente.getBandeira().equals(bandeira.toUpperCase()))
				.findFirst();
	}
}
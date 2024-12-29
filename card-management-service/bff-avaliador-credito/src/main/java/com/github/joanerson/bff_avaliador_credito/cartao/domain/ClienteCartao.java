package com.github.joanerson.bff_avaliador_credito.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteCartao {
	private UUID idClienteCartao;
	private String cpf;
	private UUID idCartao;
	private BigDecimal limite;
}
package com.github.joanerson.bff_avaliador_credito.cartao.domain;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cartao {
    private UUID idCartao;
    private String nome;
    private CartaoBandeira bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;
}
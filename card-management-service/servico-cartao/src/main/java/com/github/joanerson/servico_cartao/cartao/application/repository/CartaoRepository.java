package com.github.joanerson.servico_cartao.cartao.application.repository;

import java.math.BigDecimal;
import java.util.List;

import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

public interface CartaoRepository {
	Cartao salva(Cartao cartao);
	List<Cartao> CartoesRendaMenorIgual(BigDecimal rendaBigDecimal);

}
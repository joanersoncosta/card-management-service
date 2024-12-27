package com.github.joanerson.servico_cartao.cartao.infra;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.joanerson.servico_cartao.cartao.application.repository.CartaoRepository;
import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CartaoInfraRepository implements CartaoRepository {
	private final CartaoSpringDataJpaRepository cartaoSpringDataJpaRepository;
	
	@Override
	public Cartao salva(Cartao cartao) {
		log.info("[start] CartaoInfraRepository - salva");
		cartaoSpringDataJpaRepository.save(cartao);
		log.info("[finish] CartaoInfraRepository - salva");
		return cartao;
	}

	@Override
	public List<Cartao> CartoesRendaMenorIgual(BigDecimal rendaBigDecimal) {
		log.info("[start] CartaoInfraRepository - CartoesRendaMenorIgual");
		List<Cartao> cartoes = cartaoSpringDataJpaRepository.findByRendaLessThanEqual(rendaBigDecimal);
		log.info("[finish] CartaoInfraRepository - CartoesRendaMenorIgual");
		return cartoes;
	}

}
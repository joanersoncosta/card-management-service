package com.github.joanerson.servico_cartao.cartao.infra;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanerson.servico_cartao.cartao.application.repository.CartaoRepository;
import com.github.joanerson.servico_cartao.cartao.domain.Cartao;
import com.github.joanerson.servico_cartao.handler.APIException;

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

	@Override
	public Cartao buscaCartaoPorId(UUID idCartao) {
		log.info("[start] CartaoInfraRepository - CartoesRendaMenorIgual");
		Cartao cartao = cartaoSpringDataJpaRepository.findById(idCartao)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cartão não encontrado."));
		log.info("[finish] CartaoInfraRepository - CartoesRendaMenorIgual");
		return cartao;
	}
}
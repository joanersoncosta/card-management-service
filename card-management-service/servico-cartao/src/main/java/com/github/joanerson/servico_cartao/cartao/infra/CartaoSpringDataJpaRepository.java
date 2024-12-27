package com.github.joanerson.servico_cartao.cartao.infra;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

public interface CartaoSpringDataJpaRepository  extends JpaRepository<Cartao, UUID>{
	List<Cartao> findByRendaLessThanEqual(BigDecimal rendaBigDecimal);
}
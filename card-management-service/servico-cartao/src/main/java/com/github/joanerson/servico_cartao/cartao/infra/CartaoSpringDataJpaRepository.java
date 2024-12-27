package com.github.joanerson.servico_cartao.cartao.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanerson.servico_cartao.cartao.domain.Cartao;

public interface CartaoSpringDataJpaRepository  extends JpaRepository<Cartao, UUID>{

}
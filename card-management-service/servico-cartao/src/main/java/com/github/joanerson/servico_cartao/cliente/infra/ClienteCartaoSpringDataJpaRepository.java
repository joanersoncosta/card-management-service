package com.github.joanerson.servico_cartao.cliente.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

public interface ClienteCartaoSpringDataJpaRepository  extends JpaRepository<ClienteCartao, UUID>{
	Optional<ClienteCartao> findByCpf(String cpf);
}
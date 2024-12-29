package com.github.joanerson.servico_cartao.cliente.application.repository;

import java.util.Optional;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

public interface ClienteCartaoRepository {
	Optional<ClienteCartao> buscaCartaoPorCpf(String cpf);
}
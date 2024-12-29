package com.github.joanerson.servico_cartao.cliente.application.service;

import java.util.Optional;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

public interface ClienteCartaoService {
	Optional<ClienteCartao> buscaCartaoPorCpf(String cpf);
}
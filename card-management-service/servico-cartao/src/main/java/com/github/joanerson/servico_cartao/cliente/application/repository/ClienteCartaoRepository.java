package com.github.joanerson.servico_cartao.cliente.application.repository;

import java.util.List;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

public interface ClienteCartaoRepository {
	List<ClienteCartao> buscaCartaoPorCpf(String cpf);
}
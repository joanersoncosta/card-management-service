package com.github.joanerson.servico_cartao.cliente.application.service;

import java.util.List;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

public interface ClienteCartaoService {
	List<ClienteCartao> buscaCartaoPorCpf(String cpf);
}
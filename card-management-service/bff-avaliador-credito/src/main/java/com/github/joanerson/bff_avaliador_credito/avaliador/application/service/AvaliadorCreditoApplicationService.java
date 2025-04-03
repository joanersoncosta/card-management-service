package com.github.joanerson.bff_avaliador_credito.avaliador.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.CartaoAprovadoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.DadosSolicitacaoEmissaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.ProtocoloSolicitacaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;
import com.github.joanerson.bff_avaliador_credito.cartao.application.service.CartaoService;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;
import com.github.joanerson.bff_avaliador_credito.cartao.infra.CartaoDetalhadoResponse;
import com.github.joanerson.bff_avaliador_credito.cliente.application.service.ClienteService;
import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AvaliadorCreditoApplicationService implements AvaliadorCreditoService {
	private final ClienteService clienteService;
	private final CartaoService cartaoService;
	
	@Override
	public List<CartaoAprovadoResponse> realizaAvaliacaoCliente(String cpf, BigDecimal renda) {
		log.info("[start] AvaliadorCreditoApplicationService - realizaAvaliacaoCliente");
		log.debug("[renda] {}", renda);
		List<CartaoResponse> cartoes = cartaoService.buscaCartaoPorRenda(renda);
		log.debug("[finish] AvaliadorCreditoApplicationService - realizaAvaliacaoCliente");
		return CartaoAprovadoResponse.converte(cartoes);
	}
	
	@Override
	public SituacaoCliente consultaSituacaoCliente(String cpf) {
		log.info("[start] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		Cliente cliente = clienteService.buscaClientePorCpf(cpf);
		log.debug("[cliente] {}", cliente.toString());
		List<ClienteCartao> cartoes = cartaoService.buscaCartaoPorCpf(cpf);
		log.debug("[cartoes] {}", cartoes.toString());
		log.debug("[finish] AvaliadorCreditoApplicationService - consultaSituacaoCliente");
		return SituacaoCliente.converte(cliente, cartoes);
	}

	@Override
	public ProtocoloSolicitacaoCartao solicitarCartao(DadosSolicitacaoEmissaoCartao request) {
		log.info("[start] AvaliadorCreditoApplicationService - solicitarCartao");
		log.debug("[dadosSolicitacaoEmissaoCartao] {}", request.toString());
		Cliente cliente = clienteService.buscaClientePorCpf(request.cpf());
		CartaoDetalhadoResponse cartao =  cartaoService.buscaCartaoPorId(request.idCartao());
		
		log.debug("[finish] AvaliadorCreditoApplicationService - solicitarCartao");
		return new ProtocoloSolicitacaoCartao();
	}
}
package com.github.joanerson.bff_avaliador_credito.cartao.infra.cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;
import com.github.joanerson.bff_avaliador_credito.cartao.infra.CartaoDetalhadoResponse;
import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;
import com.github.joanerson.bff_avaliador_credito.handler.APIException;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class CartaoInfraClient implements CartaoWebService {
    private final WebClient webClient;
    @Value("url.alb.cartao")
    private String urlServiceCartao;
    
    public CartaoInfraClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
	@Override
	public CartaoDetalhadoResponse buscaCartaoPorId(UUID idCartao) {
        log.info("[start] CartaoInfraClient - buscaCartaoPorId");
        log.info("[finish] CartaoInfraClient - buscaCartaoPorId");
		return null;
	}

	@Override
	public List<ClienteCartao> buscaCartaoDoClientePorCpf(String cpf) {
        log.info("[start] CartaoInfraClient - buscaCartaoDoClientePorCpf");
        log.info("[finish] CartaoInfraClient - buscaCartaoDoClientePorCpf");
		return null;
	}

	@Override
	public List<CartaoResponse> buscaCartaoPorRenda(BigDecimal renda) {
        log.info("[start] CartaoInfraClient - buscaCartaoPorRenda");
        log.info("[finish] CartaoInfraClient - buscaCartaoPorRenda");
        return null;
	}

}
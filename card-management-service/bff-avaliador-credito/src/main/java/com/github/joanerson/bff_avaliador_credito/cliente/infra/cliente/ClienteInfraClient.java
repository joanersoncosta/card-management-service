package com.github.joanerson.bff_avaliador_credito.cliente.infra.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class ClienteInfraClient implements ClienteInfraService {
    private final WebClient webClient;
    @Value("url.alb.cliente")
    private String urlServiceCliente;
    
    public ClienteInfraClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
    @Override
    public Cliente buscaClientePorCpf(String cpf) {
        log.info("[start] ClienteInfraClient - buscaClientePorCpf");
        log.info("[urlServiceCliente] {}", urlServiceCliente);
        Cliente cliente = detalhaCliente(cpf);
//        		.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado para este CPF."));
        log.info("[finish] ClienteInfraClient - buscaClientePorCpf");
        return cliente;
    }

    private Cliente detalhaCliente(String cpf) {
        log.info("[start] ClienteInfraClient - detalhaCliente");
        Cliente cliente = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port(8081)
                        .path("/servico-cliente/api/v1/cliente/buscar/cpf")
                        .queryParam("cpf", cpf)
                        .build())
                .retrieve()
                .bodyToMono(Cliente.class)
                .doOnSuccess(response -> log.info("Cliente encontrado com sucesso!"))
                .doOnError(WebClientResponseException.class, e -> {
                    log.error("Erro ao buscar cliente: {}, {}", e.getStatusCode(), e.getResponseBodyAsString());
                    throw APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado para este CPF.");
                })
                .onErrorResume(Mono::error)
                .block();
        log.info("[finish] ClienteInfraClient - detalhaCliente");
        return cliente;
    }

}
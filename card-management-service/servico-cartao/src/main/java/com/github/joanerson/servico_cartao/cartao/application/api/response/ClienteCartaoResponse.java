package com.github.joanerson.servico_cartao.cartao.application.api.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.github.joanerson.servico_cartao.cliente.domain.ClienteCartao;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "Informações sobre o cartão de crédito de um cliente")
public class ClienteCartaoResponse {

    @Schema(description = "Identificador único do relacionamento entre cliente e cartão", example = "d8582d8b-0a5f-4c79-b928-d4b0fcd5e5c4")
    private UUID idClienteCartao;

    @Schema(description = "CPF do cliente", example = "639.207.520-82")
    private String cpf;

    @Schema(description = "Identificador único do cartão associado", example = "a8274e28-d145-4234-a68b-d24dfab2bb65")
    private UUID idCartao;

    @Schema(description = "Limite de crédito disponível no cartão", example = "5000.00")
    private BigDecimal limite;
    
	public ClienteCartaoResponse(ClienteCartao clienteCartao) {
		this.idClienteCartao = clienteCartao.getIdClienteCartao();
		this.cpf = clienteCartao.getCpf();
		this.idCartao = clienteCartao.getIdCartao();
		this.limite = clienteCartao.getLimite();
	}

	public static List<ClienteCartaoResponse> converte(List<ClienteCartao> clienteResponse) {
		return clienteResponse.stream()
				.map(ClienteCartaoResponse::new)
				.collect(Collectors.toList());
	}
}
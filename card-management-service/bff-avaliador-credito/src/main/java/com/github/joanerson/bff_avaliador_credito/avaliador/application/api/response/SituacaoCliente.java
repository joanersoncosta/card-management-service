package com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response;

import java.util.List;
import java.util.UUID;

import com.github.joanerson.bff_avaliador_credito.cartao.domain.ClienteCartao;
import com.github.joanerson.bff_avaliador_credito.cliente.domain.Cliente;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Informações detalhadas sobre a situação do cliente.")
public record SituacaoCliente(

    @Schema(description = "ID único do cliente", example = "f9d0bde5-0f9a-4a5b-bc8d-f24f89ed3a5b")
    UUID idCliente,

    @Schema(description = "Nome completo do cliente", example = "Maria Santos")
    String nome,

    @Schema(description = "Endereço de e-mail do cliente", example = "maria@gmail.com")
    String email,

    @Schema(description = "Idade do cliente", example = "30")
    Integer idade,

    @ArraySchema(schema = @Schema(implementation = ClienteCartao.class))
    List<ClienteCartao> cartaoCliente
) {

	public static SituacaoCliente converte(Cliente cliente, List<ClienteCartao> cartoes) {
	    return new SituacaoCliente(cliente.getIdCliente(), cliente.getNome(), cliente.getEmail(), cliente.getIdade(), cartoes);
	}
}
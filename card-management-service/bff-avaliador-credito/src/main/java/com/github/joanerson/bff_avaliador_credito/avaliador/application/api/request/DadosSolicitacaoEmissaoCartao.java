package com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Modelo para solicitar um cartão")
public record DadosSolicitacaoEmissaoCartao(
		    @NotNull(message = "O ID do cartão não pode ser nulo")
		    @Schema(description = "Identificador único do cartão", example = "b7234e19-65b1-42d0-9d23-f82613f7d29c")
		    UUID idCartao,

		    @NotNull(message = "O CPF não pode ser nulo")
		    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato XXX.XXX.XXX-XX")
		    @Schema(description = "Número do CPF do solicitante", example = "123.456.789-00")
		    String cpf,

		    @NotNull(message = "O CEP não pode ser nulo")
		    @Schema(description = "Cep do seu endereço", example = "01001000")
		    String cep
	) {
}
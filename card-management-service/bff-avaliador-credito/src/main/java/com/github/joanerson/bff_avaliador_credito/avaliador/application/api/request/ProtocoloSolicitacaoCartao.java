package com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de solicitação de cartão com protocolo único")
public record ProtocoloSolicitacaoCartao(
    @Schema(description = "Identificador único do protocolo", example = "4f15b56d-2a69-412f-9d76-688ce87c6f21") 
    UUID idProtocolo
) {
    public ProtocoloSolicitacaoCartao() {
        this(UUID.randomUUID());
    }
}
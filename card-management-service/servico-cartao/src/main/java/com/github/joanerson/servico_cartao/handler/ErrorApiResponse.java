package com.github.joanerson.servico_cartao.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Schema(description = "Resposta genérica para erros da API")
public class ErrorApiResponse {

    @Schema(description = "Mensagem descritiva do erro ocorrido", example = "Requisição inválida")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(description = "Descrição detalhada do erro", example = "Descrição da mensagem.")
    private String description;
}
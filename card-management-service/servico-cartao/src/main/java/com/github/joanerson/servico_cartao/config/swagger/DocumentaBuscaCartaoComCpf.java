package com.github.joanerson.servico_cartao.config.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import com.github.joanerson.servico_cartao.cartao.application.api.response.ClienteCartaoResponse;
import com.github.joanerson.servico_cartao.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
    summary = "Obtém os cartões com cpf",
    description = "Este endpoint retorna o cartão do clientes pelo 'CPF'.",
    parameters = {
        @Parameter(name = "cpf", description = "CPF do cliente", required = true, example = "639.207.520-82")
    },
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Cartão encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteCartaoResponse.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Nenhum cartão encontrado para este cpf"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Erro interno do servidor.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))
        )
    }
)
public @interface DocumentaBuscaCartaoComCpf {

}
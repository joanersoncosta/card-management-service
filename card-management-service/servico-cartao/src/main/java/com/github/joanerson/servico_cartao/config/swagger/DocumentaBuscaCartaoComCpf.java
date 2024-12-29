package com.github.joanerson.servico_cartao.config.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Target(ElementType.METHOD) // A anotação será aplicada a métodos
@Retention(RetentionPolicy.RUNTIME) // A anotação estará disponível em tempo de execução
@Operation(
    summary = "Obtém os cartões com cpf",
    description = "Este endpoint retorna uma lista de cartões disponíveis para clientes com a renda até o valor especificado no parâmetro 'renda'.",
    parameters = {
        @Parameter(name = "renda", description = "Valor máximo da renda mensal para filtrar os cartões", required = true, example = "5000")
    },
    responses = {
        @ApiResponse(
            responseCode = "200",
            description = "Cartão encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CartaoResponse.class))
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
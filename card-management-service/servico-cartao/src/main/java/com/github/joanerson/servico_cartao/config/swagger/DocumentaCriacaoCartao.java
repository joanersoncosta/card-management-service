package com.github.joanerson.servico_cartao.config.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoNovoResponse;
import com.github.joanerson.servico_cartao.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
    summary = "Cria um novo cartão",
    description = "Este método cria um novo cartão."
)
@ApiResponses(value = {
    @ApiResponse(
        responseCode = "201",
        description = "Cartão criado com sucesso.",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CartaoNovoResponse.class))
    ),
    @ApiResponse(
        responseCode = "500",
        description = "Erro interno do servidor.",
        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))
    )
})
public @interface DocumentaCriacaoCartao {
}
package com.github.joanerson.servico_cartao.cartao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoNovoResponse;
import com.github.joanerson.servico_cartao.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public interface CartaoAPI {

	@Operation(summary = "Cria um novo cartão", description = "Este método cria um novo cartão, associando-o a um cliente. O cartão será gerado com os dados informados e estará disponível para uso após a criação.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cartão criado com sucesso.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CartaoNovoResponse.class))),
			@ApiResponse(responseCode = "409", description = "Já existe um cartão com este número.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))) })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	CartaoNovoResponse postNovoCartao(@RequestBody @Valid CartaoNovoRequest cartaoRequest);

}
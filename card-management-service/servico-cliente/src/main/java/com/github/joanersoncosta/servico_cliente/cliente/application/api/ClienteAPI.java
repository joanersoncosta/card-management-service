package com.github.joanersoncosta.servico_cliente.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.servico_cliente.cliente.application.api.request.ClienteNovoRequest;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteCriadoResponse;
import com.github.joanersoncosta.servico_cliente.cliente.application.api.response.ClienteResponse;
import com.github.joanersoncosta.servico_cliente.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "ClienteAPI", description = "Controle responsavel pelas operações do cliente.")
@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {

	@Operation(summary = "Cria novo cliente")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Cliente criado"),
			@ApiResponse(responseCode = "409", description = "Já existe um cliente com este email.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))) })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	ClienteCriadoResponse criaNovoCliente(@RequestBody @Valid ClienteNovoRequest clienteRequest);

	@Operation(summary = "Busca cliente por CPF")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClienteResponse.class))),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado para este CPF.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))) })
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/buscar/cpf")
	ClienteResponse buscaClientePorCpf(@RequestParam(value = "cpf") String cpf);

}
package com.github.joanerson.servico_cartao.cartao.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoNovoResponse;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public interface CartaoAPI {

	@Operation(summary = "Cria um novo cartão", description = "Este método cria um novo cartão.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Cartão criado com sucesso.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CartaoNovoResponse.class))),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))) })
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	void postNovoCartao(@RequestBody @Valid CartaoNovoRequest cartaoRequest);

	@Operation(summary = "Obtém os cartões com renda até o valor informado", description = "Este endpoint retorna uma lista de cartões disponíveis para clientes com a renda até o valor especificado no parâmetro 'renda'.", parameters = {
			@Parameter(name = "renda", description = "Valor máximo da renda mensal para filtrar os cartões", required = true, example = "5000") }, responses = {
					@ApiResponse(responseCode = "200", description = "Lista de cartões encontrados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CartaoResponse.class))),
					@ApiResponse(responseCode = "400", description = "Requisição inválida"),
					@ApiResponse(responseCode = "404", description = "Nenhum cartão encontrado para a renda especificada."),
					@ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	List<CartaoResponse> getCartoesRendaAte(@RequestParam("renda") Long renda);
}
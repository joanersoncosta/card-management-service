package com.github.joanerson.bff_avaliador_credito.avaliador.application.api;

import java.math.BigDecimal;
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

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.CartaoAprovadoResponse;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.DadosSolicitacaoEmissaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.request.ProtocoloSolicitacaoCartao;
import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.SituacaoCliente;
import com.github.joanerson.bff_avaliador_credito.handler.ErrorApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AvaliadorCreditoAPI", description = "Controle responsavel pelas operações do Avaliador Credito.")
@RestController
@RequestMapping("/v1/avaliador")
public interface AvaliadorCreditoAPI {

	@Operation(summary = "GET home")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))) })
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	String getHome();
	
	@GetMapping(value = "/realiza/avaliacao", params = {"cpf", "renda"})
	public List<CartaoAprovadoResponse> getRealizaAvaliacaoCliente(@RequestParam("cpf") @Parameter(example = "639.207.520-82") String cpf, @RequestParam("renda") @Parameter(example = "4000.00") BigDecimal renda);
	
	@GetMapping(value = "/situacao-cliente", params = "cpf")
	public SituacaoCliente getConsultaSituacaoCliente(@RequestParam("cpf") @Parameter(example = "639.207.520-82") String cpf);
	
	@PostMapping(value = "/silicitacoes-cartao")
	public ProtocoloSolicitacaoCartao postSolicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao);
	
}
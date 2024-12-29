package com.github.joanerson.servico_cartao.cartao.application.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.servico_cartao.cartao.application.api.request.CartaoNovoRequest;
import com.github.joanerson.servico_cartao.cartao.application.api.response.CartaoResponse;
import com.github.joanerson.servico_cartao.cartao.application.api.response.ClienteCartaoResponse;
import com.github.joanerson.servico_cartao.config.swagger.DocumentaBuscaCartaoComCpf;
import com.github.joanerson.servico_cartao.config.swagger.DocumentaCriacaoCartao;
import com.github.joanerson.servico_cartao.config.swagger.DocumentaListaCartoesRenda;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public interface CartaoAPI {

	@DocumentaCriacaoCartao
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "/cadastra")
	void postNovoCartao(@RequestBody @Valid CartaoNovoRequest cartaoRequest);

	@DocumentaListaCartoesRenda	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/busca/renda", params = "renda")
	List<CartaoResponse> getCartoesRendaAte(@RequestParam("renda") @Parameter(example = "4000.00") BigDecimal renda);
	
	@DocumentaBuscaCartaoComCpf
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/busca/cpf", params = "cpf")
	List<ClienteCartaoResponse> getBuscaCartaoPorCpfResponse(@RequestParam("cpf") @Parameter(example = "639.207.520-82") String cpf);
}
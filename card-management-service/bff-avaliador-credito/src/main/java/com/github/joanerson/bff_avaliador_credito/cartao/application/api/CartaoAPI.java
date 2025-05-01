package com.github.joanerson.bff_avaliador_credito.cartao.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanerson.bff_avaliador_credito.avaliador.application.api.response.CartaoResponse;
import com.github.joanerson.bff_avaliador_credito.cartao.application.api.response.CartaoDetalhadoResponse;

@RestController
@RequestMapping("/cartao")
public interface CartaoAPI {

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{idCartao}")
	CartaoDetalhadoResponse getCartaoPorId(@PathVariable UUID idCartao);
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping()
	List<CartaoResponse> getListaCartoes();

}
package com.github.joanersoncosta.servico_cliente.cliente.application.api.response;

import java.util.UUID;

import com.github.joanersoncosta.servico_cliente.cliente.domain.Cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClienteResponse {
	@Schema(description = "ID único do cliente", example = "f9d0bde5-0f9a-4a5b-bc8d-f24f89ed3a5b")
    private UUID idCliente;
    @Schema(description = "Nome completo do cliente", example = "Maria Santos")
    private String nome;
    @Schema(description = "CPF do cliente", example = "639.207.520-82")
    private String cpf;
    @Schema(description = "Endereço de e-mail do cliente", example = "maria@gmail.com")
    private String email;
    @Schema(description = "Idade do cliente", example = "30")
    private Integer idade;
    
    public ClienteResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.idade = cliente.getIdade();
	}
}
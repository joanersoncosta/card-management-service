package com.github.joanerson.servico_cartao.cliente.domain;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "cliente_cartao")
public class ClienteCartao {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_cliente_cartao")
	private UUID idClienteCartao;
    @Column(name = "cpf")
	private String cpf;
    @Column(columnDefinition = "uuid", name = "id_cartao")
	private UUID idCartao;
    @Column(name = "limite")
	private BigDecimal limite;
	
	public ClienteCartao(UUID idClienteCartao, String cpf, UUID idCartao, BigDecimal limite) {
		this.idClienteCartao = idClienteCartao;
		this.cpf = cpf;
		this.idCartao = idCartao;
		this.limite = limite;
	}
    
    private String gerarNumeroCartao() {
        String bin = "045";

        Random rand = new Random();
        String numerosAleatorios = IntStream.range(0, 9)
            .mapToObj(i -> String.valueOf(rand.nextInt(10)))
            .collect(Collectors.joining());

        String numeroCartao = bin + numerosAleatorios;
        int digitoVerificacao = calcularDigitoVerificacao(numeroCartao);

        return numeroCartao + digitoVerificacao;
    }

    private int calcularDigitoVerificacao(String numeroCartao) {
        int soma = IntStream.range(0, numeroCartao.length())
            .map(i -> {
                int digito = Character.getNumericValue(numeroCartao.charAt(numeroCartao.length() - 1 - i));
                if (i % 2 == 1) {
                    digito *= 2;
                    if (digito > 9) digito -= 9;
                }
                return digito;
            })
            .sum();
        return (10 - soma % 10) % 10;
    }
}
package com.github.joanerson.servico_cartao.cliente.domain;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClienteCartao {
	
    public static String gerarNumeroCartao() {
        // 1. Defina o BIN (Banco Identificador) fictício - os 6 primeiros dígitos
        String bin = "045"; // Exemplo de BIN fictício

        // 2. Preencha os próximos 9 dígitos de forma aleatória usando Stream
        Random rand = new Random();
        String numerosAleatorios = IntStream.range(0, 9) // Gera 9 números
            .mapToObj(i -> String.valueOf(rand.nextInt(10))) // Converte para String
            .collect(Collectors.joining()); // Junta em uma única string

        // 3. Calcule o dígito de verificação (último dígito) usando o Algoritmo de Luhn
        String numeroCartao = bin + numerosAleatorios;
        int digitoVerificacao = calcularDigitoVerificacao(numeroCartao);

        // Retorna o número do cartão com o dígito de verificação
        return numeroCartao + digitoVerificacao;
    }

    // Função para calcular o dígito de verificação (Luhn Algorithm)
    private static int calcularDigitoVerificacao(String numeroCartao) {
        // Cria um Stream para percorrer os dígitos de trás para frente e calcular a soma
        int soma = IntStream.range(0, numeroCartao.length())
            .map(i -> {
                int digito = Character.getNumericValue(numeroCartao.charAt(numeroCartao.length() - 1 - i));
                if (i % 2 == 1) { // Para os dígitos em posição ímpar (contando de trás para frente)
                    digito *= 2;
                    if (digito > 9) digito -= 9; // Subtrai 9 se for maior que 9
                }
                return digito;
            })
            .sum();

        // O dígito de verificação é o valor necessário para que a soma seja múltiplo de 10
        return (10 - soma % 10) % 10;
    }
}
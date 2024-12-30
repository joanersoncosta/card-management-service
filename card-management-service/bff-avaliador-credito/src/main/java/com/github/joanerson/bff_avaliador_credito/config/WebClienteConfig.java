package com.github.joanerson.bff_avaliador_credito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClienteConfig {

	@Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
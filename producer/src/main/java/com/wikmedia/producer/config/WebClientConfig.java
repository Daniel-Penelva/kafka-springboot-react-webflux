package com.wikmedia.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}

/**
 * Essa classe é uma configuração para criar um bean de WebClient.Builder usando a anotação @Configuration. 
 * Anotações: 
 * 
 * @Configuration: Essa anotação é usada para indicar que a classe é uma classe de configuração. No contexto do Spring Framework, ela é 
 * frequentemente usada para configurar beans e outros componentes do aplicativo.
 * 
 * @Bean: Essa anotação é usada para indicar que um método dentro da classe está sendo usado para criar e configurar um bean. No meu caso, o 
 * método webClientBuilder() cria e retorna um bean do tipo WebClient.Builder.
 * 
 * WebClient.Builder: WebClient é uma classe do Spring WebFlux que fornece uma maneira reativa de fazer solicitações HTTP. A classe 
 * WebClient.Builder é usada para construir instâncias de WebClient.
 * 
 * A função dessa classe e do método anotado com @Bean é fornecer uma instância de WebClient.Builder como um bean gerenciado pelo Spring. Isso 
 * permite que outras partes do código injetem e usem esse WebClient.Builder para criar instâncias de WebClient em seus próprios componentes.
 * 
*/
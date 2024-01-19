package com.wikmedia.producer.stream;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wikmedia.producer.producer.WikimediaProducer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer producer) {
        this.webClient = webClientBuilder.baseUrl("https://stream.wikimedia.org/v2").build();
        this.producer = producer;
    }

    public void consumerStreamPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }

}

/**
 * Essa classe é um  componente de serviço (@Service) que consome um stream de eventos de alterações recentes da Wikimedia e envia esses eventos 
 * para um produtor Kafka (WikimediaProducer). 
 * 
 * Explicando passo a passo:
 * @Service: Essa anotação é do Spring Framework e é usada para indicar que a classe é um componente de serviço.
 * 
 * @Slf4j: Essa anotação é do projeto Lombok e é usada para adicionar automaticamente um logger SLF4J à classe, acessível por meio da variável log.
 * 
 * private final WebClient webClient: Um campo que representa um WebClient. WebClient é uma classe do Spring WebFlux que fornece uma maneira 
 * reativa de fazer solicitações HTTP.
 * 
 * private final WikimediaProducer producer: Um campo que representa um produtor (WikimediaProducer). Isso indica uma dependência com a classe 
 * WikimediaProducer para enviar os eventos para o Kafka.
 * 
 * public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer producer): Um construtor que aceita um WebClient.Builder 
 * e uma instância de WikimediaProducer. No construtor, o WebClient é configurado com uma base URL específica ("https://stream.wikimedia.org/v2").
 * 
 * public void consumerStreamPublish(): Um método público que consome o stream de eventos de alterações recentes da Wikimedia. Isso é feito 
 * através do WebClient, onde uma requisição HTTP GET é feita para a URI "/stream/recentchange". O corpo da resposta é convertido em um fluxo 
 * reativo de strings (Flux<String>) e, em seguida, logado utilizando o logger SLF4J.
 * 
 * Essencialmente, esta classe representa um consumidor de um stream de eventos da Wikimedia usando o Spring WebFlux. Os eventos são logados e, 
 * possivelmente, enviados para um tópico Kafka por meio do produtor (WikimediaProducer). O uso de programação reativa (Flux) indica que o 
 * consumo desses eventos é assíncrono e pode ser feito de maneira eficiente, lidando com grandes volumes de dados de forma escalável.
*/
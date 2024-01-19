package com.wikmedia.producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("wikimedia-stream", msg);
    }
}

/**
 * Essa classe é um  componente de serviço (@Service) que é responsável por enviar mensagens para um tópico Kafka. 
 * 
 * Explicação passo a passo: 
 * @RequiredArgsConstructor: Essa anotação é do projeto Lombok e é usada para gerar automaticamente um construtor que inicializa todos os campos 
 * marcados como final. Neste caso, ela é usada para criar um construtor que inicializa o campo kafkaTemplate.
 * 
 * private final KafkaTemplate<String, String> kafkaTemplate: Um campo que representa um KafkaTemplate. KafkaTemplate é uma classe do Spring 
 * Kafka que fornece métodos convenientes para enviar mensagens para tópicos do Apache Kafka.
 * 
 * public void sendMessage(String msg): Um método público que aceita uma mensagem como parâmetro e a envia para o tópico "wikimedia-stream" 
 * usando o kafkaTemplate.
 * 
 * O propósito dessa classe, WikimediaProducer, é encapsular a lógica de envio de mensagens para um tópico Kafka específico (wikimedia-stream). 
 * Ao utilizar a injeção de dependência através do construtor, o KafkaTemplate é fornecido no momento da criação da instância da classe, 
 * permitindo que ela seja utilizada de forma eficiente para enviar mensagens para o tópico mencionado. Isso é especialmente útil em cenários 
 * onde a comunicação assíncrona e a troca de mensagens são parte do design da aplicação, com o Apache Kafka sendo um componente-chave para essa 
 * funcionalidade.
*/

/* IMPORTANTE!!!
Apache Kafka - SITE (STEP 5): https://kafka.apache.org/quickstart
READ THE EVENTS - para o caso do kafka instalado - usar o terminal: 
bin/kafka-console-consumer.sh --topic wikimedia-stream --from-beginning --bootstrap-server localhost:9092

No meu caso para produzir a mensagem via kafka utilizando o docker - usar o terminal:
docker-compose exec -it kafka kafka-console-consumer.sh --topic wikimedia-stream --bootstrap-server localhost:9092

*/ 
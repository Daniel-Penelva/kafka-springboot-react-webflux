package com.wikmedia.producer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wikmedia.producer.stream.WikimediaStreamConsumer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {

    private final WikimediaStreamConsumer streamConsumer;

    // http://localhost:8080/api/v1/wikimedia
    @GetMapping
    public void startPublishing(){
        streamConsumer.consumerStreamPublish();
    }
    
}

/* IMPORTANTE!!!
Apache Kafka - SITE (STEP 5): https://kafka.apache.org/quickstart
READ THE EVENTS - para o caso do kafka instalado - usar o terminal: 
bin/kafka-console-consumer.sh --topic wikimedia-stream --from-beginning --bootstrap-server localhost:9092

No meu caso para produzir a mensagem via kafka utilizando o docker - usar o terminal:
docker-compose exec -it kafka kafka-console-consumer.sh --topic wikimedia-stream --bootstrap-server localhost:9092

*/ 
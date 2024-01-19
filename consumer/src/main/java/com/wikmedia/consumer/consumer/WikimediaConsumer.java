package com.wikmedia.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumerMsg(String msg){
        log.info(String.format("Consuming the message from wikimedia-stream Topic :: %s", msg));

        // Aqui pode fazer o que quiser com os dados, ou seja,  pode adicionar a lógica de processamento da mensagem conforme necessário.
    }
    
}

/**
 * Essa classe é um consumidor Kafka configurado com o Spring Kafka. 
 * 
 * As principais características e explicações:
 * 
 * @Service: A anotação @Service é do Spring Framework e é usada para indicar que esta classe é um componente de serviço. Os serviços geralmente 
 * contêm lógica de negócios e são gerenciados pelo contêiner Spring.
 * 
 * @Slf4j: A anotação @Slf4j é do projeto Lombok e é usada para gerar automaticamente um logger SLF4J (log). Isso permite que use métodos de log 
 * sem precisar criar explicitamente um objeto de logger na classe.
 * 
 * @KafkaListener: A anotação @KafkaListener é fornecida pelo Spring Kafka e é usada para marcar um método que deve ser invocado quando mensagens 
 * são recebidas de um tópico Kafka específico. 
 *    -> topics = "wikimedia-stream": Indica o tópico do qual este consumidor irá consumir mensagens. No exemplo, é "wikimedia-stream".
 *    -> groupId = "myGroup": Indica o ID do grupo Kafka ao qual este consumidor pertence. Isso é usado para identificar o grupo de consumidores 
 *       e rastrear o progresso da leitura no tópico. 
 * 
 * consumerMsg(String msg): Este é o método que será invocado sempre que uma mensagem for recebida do tópico "wikimedia-stream". O parâmetro msg 
 * contém a mensagem recebida do tópico. A linha log.info(String.format("Consuming the message from wikimedia-stream Topic :: %s", msg)); loga a 
 * mensagem recebida.
 * 
 * No geral, esta classe configura um consumidor Kafka que está pronto para receber mensagens do tópico "wikimedia-stream" e executar a lógica 
 * de processamento no método consumerMsg. O log é usado para registrar as mensagens recebidas. 
*/
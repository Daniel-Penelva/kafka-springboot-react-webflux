package com.wikmedia.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaTopicConfig {

    @Bean
    public NewTopic wikimediaStreamTopic(){
        return TopicBuilder
            .name("wikimedia-stream")
            .build();
    }
    
}

/**
 * Essa classe usa a anotação @Configuration para definir um tópico no Apache Kafka. A classe WikimediaTopicConfig está configurando um tópico 
 * chamado "wikimedia-stream" usando o conceito de configuração baseada em Java.
 * 
 * Explicando passo a passo:
 * 
 * @Configuration: A anotação @Configuration em uma classe Java indica ao Spring que esta classe contém configurações específicas para o contexto 
 * da aplicação.
 * 
 * @Bean: A anotação @Bean é usada para indicar que o método wikimediaStreamTopic é um método de fábrica de bean. Ele informa ao Spring que o 
 * retorno desse método deve ser gerenciado como um bean dentro do contexto de aplicação.
 * 
 * NewTopic: NewTopic é uma classe do Spring Kafka que representa um tópico Kafka. Ela é usada para definir e configurar detalhes de um tópico.
 * 
 * TopicBuilder: TopicBuilder é uma classe utilitária do Spring Kafka que facilita a construção de instâncias de tópicos (NewTopic). Ela fornece 
 * métodos de construção fluente para simplificar a criação de tópicos.
 * 
 * wikimediaStreamTopic(): Este é o método de fábrica de bean. Quando o Spring inicia, ele chama esse método para criar e configurar um bean do 
 * tipo NewTopic. O método define o tópico "wikimedia-stream" usando o TopicBuilder.
 * 
 * Neste caso, o método está criando um tópico sem configurações adicionais. Se necessário pode adicionar mais configurações ao tópico, como 
 * número de partições, fatores de replicação, configurações de retenção, etc.
 * 
 * Essa configuração é especialmente útil em ambientes Spring Kafka para definir tópicos programaticamente, garantindo que eles estejam disponíveis 
 * quando a aplicação é iniciada. Isso é particularmente útil em cenários em que deseja garantir que os tópicos estejam criados antes que outros 
 * componentes do Kafka consumam ou produzam mensagens nesses tópicos.
*/
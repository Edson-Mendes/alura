package br.com.alurafood.avaliacao.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoAMQPConfiguration {

  @Bean
  public Jackson2JsonMessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory conn, Jackson2JsonMessageConverter messageConverter) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(conn);
    rabbitTemplate.setMessageConverter(messageConverter);

    return rabbitTemplate;
  }

  @Bean
  public Queue filaDetalhesAvaliacao() {
    return QueueBuilder.nonDurable("pagamentos.detalhes-avaliacao")
        .deadLetterExchange("pagamentos.dlx")
        .build();
  }

  @Bean
  public Queue filaDlqDetalhesAvaliacao() {
    return QueueBuilder.nonDurable("pagamentos.detalhes-avaliacao-dlq").build();
  }

  @Bean
  public FanoutExchange funoutExchange() {
    return ExchangeBuilder
        .fanoutExchange("pagamentos.ex").build();
  }

  @Bean
  public FanoutExchange deadLetterExchange() {
    return ExchangeBuilder
        .fanoutExchange("pagamentos.dlx").build();
  }

  @Bean
  public Binding bindingPagamentoPedido() {
    return BindingBuilder.bind(filaDetalhesAvaliacao()).to(funoutExchange());
  }

  @Bean
  public Binding bindingDlxPagamentoPedido() {
    return BindingBuilder.bind(filaDlqDetalhesAvaliacao()).to(deadLetterExchange());
  }

  @Bean
  public RabbitAdmin criaRabbitAdmin(ConnectionFactory conn) {
    return new RabbitAdmin(conn);
  }

  @Bean
  public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
    return event -> rabbitAdmin.initialize();
  }

}

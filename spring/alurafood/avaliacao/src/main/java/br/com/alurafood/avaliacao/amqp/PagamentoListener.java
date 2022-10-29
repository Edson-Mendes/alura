package br.com.alurafood.avaliacao.amqp;

import br.com.alurafood.avaliacao.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PagamentoListener {

  @RabbitListener(queues = {"pagamentos.detalhes-avaliacao"})
  public void recebeMensagem(PagamentoDto pagamento) {
    System.out.println(pagamento.getId());
    System.out.println(pagamento.getNumero());
    if (pagamento.getNumero().equals("0000")) {
      throw new RuntimeException("Não foi possível processar o pagamento!");
    }

    String mensagem = """
        Dados do pagamento: %s
        Número do pedido: %s
        Valor R$: %s
        Status: %s
        """.formatted(pagamento.getId(), pagamento.getPedidoId(), pagamento.getValor(), pagamento.getStatus());

    System.out.println("Recebi a mensagem tal: "+mensagem);
  }

}

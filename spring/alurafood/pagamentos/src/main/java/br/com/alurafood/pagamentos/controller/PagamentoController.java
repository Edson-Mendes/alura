package br.com.alurafood.pagamentos.controller;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.service.PagamentoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

  private final PagamentoService service;
  private final RabbitTemplate rabbitTemplate;

  @GetMapping
  public Page<PagamentoDto> listar(@PageableDefault(size = 10) Pageable pageable){
    return service.obterPagamentos(pageable);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PagamentoDto> detalhar(@PathVariable @NotNull Long id){
    PagamentoDto dto = service.obterPorId(id);

    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder) {
    PagamentoDto pagamento = service.criarPagamento(dto);
    URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

    Message message = new Message(("Criei um pagamento com o id " + pagamento.getId()).getBytes());
    rabbitTemplate.send("pagamento.concluido", message);

    return ResponseEntity.created(endereco).body(pagamento);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto) {
    PagamentoDto atualizado = service.atualizarPagamento(id, dto);
    return ResponseEntity.ok(atualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<PagamentoDto> remover(@PathVariable @NotNull Long id) {
    service.excluirPagamento(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}/confirmar")
  @CircuitBreaker(name = "atualizaPedido", fallbackMethod = "pagamentoAutorizadoComIntegracaoPendente")
  public void confirmarPagamento(@PathVariable @NotNull Long id){
    service.confirmarPagamento(id);
  }

  public void pagamentoAutorizadoComIntegracaoPendente(Long id, Exception e){
    service.alteraStatus(id);
  }

}

package br.com.alurafood.pagamentos.controller;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
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

  private final PagamentoService pagamentoService;

  @GetMapping
  public Page<PagamentoDto> listar(@PageableDefault(size = 10) Pageable pageable){
    return pagamentoService.obterPagamentos(pageable);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PagamentoDto> detalhar(@RequestParam @NotNull Long id){
    PagamentoDto dto = pagamentoService.obterPorId(id);

    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder) {
    PagamentoDto pagamento = pagamentoService.criarPagamento(dto);
    URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

    return ResponseEntity.created(endereco).body(pagamento);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto) {
    PagamentoDto atualizado = pagamentoService.atualizarPagamento(id, dto);
    return ResponseEntity.ok(atualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<PagamentoDto> remover(@PathVariable @NotNull Long id) {
    pagamentoService.excluirPagamento(id);
    return ResponseEntity.noContent().build();
  }

}
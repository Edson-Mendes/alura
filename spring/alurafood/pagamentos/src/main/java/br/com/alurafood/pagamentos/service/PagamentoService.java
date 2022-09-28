package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.model.Status;
import br.com.alurafood.pagamentos.model.entity.Pagamento;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PagamentoService {

  private final PagamentoRepository pagamentoRepository;
  private final ModelMapper modelMapper;

  public Page<PagamentoDto> obterPagamentos(Pageable pageable){
    return pagamentoRepository
        .findAll(pageable)
        .map(p -> modelMapper.map(p, PagamentoDto.class));
  }

  public PagamentoDto obterPorId(Long id){
    Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow(EntityNotFoundException::new);

    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public PagamentoDto criarPagamento(PagamentoDto dto) {
    Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
    pagamento.setStatus(Status.CRIADO);
    pagamentoRepository.save(pagamento);

    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto){
    Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
    pagamento.setId(id);
    pagamento = pagamentoRepository.save(pagamento);
    return modelMapper.map(pagamento, PagamentoDto.class);
  }

  public void excluirPagamento(Long id){
    pagamentoRepository.deleteById(id);
  }

}

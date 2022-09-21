package br.com.emendes.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
	
	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataDaUltimaVenda;
	
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataDaUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataDaUltimaVenda = dataDaUltimaVenda;
	}
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDataDaUltimaVenda() {
		return dataDaUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataDaUltimaVenda=" + dataDaUltimaVenda + "]";
	}
}

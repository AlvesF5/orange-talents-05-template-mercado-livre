package br.com.mercadozup.mercadolivre.finalizarcompra;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import br.com.mercadozup.mercadolivre.categoria.ExisteId;
import br.com.mercadozup.mercadolivre.produto.Produto;

public class CompraRequest {
	
	@NotNull @Positive 
	private Integer quantidade;
	@NotNull @ExisteId(domainClass = Produto.class, fieldName = "id")
	private Long idProduto;
	@NotNull 
	private GatewayPagamento gateway;
	
	public CompraRequest(@Positive Integer quantidade, Long idProduto, GatewayPagamento gateway) {
		this.quantidade = quantidade;
		this.idProduto = idProduto;
		this.gateway=gateway;
	}

	
	
	
	public Integer getQuantidade() {
		return quantidade;
	}


	public Long getIdProduto() {
		return idProduto;
	}

	public GatewayPagamento getGateway() {
		return gateway;
	}
	
	
	
	
}

package br.com.mercadozup.mercadolivre.finalizarcompra;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.mercadozup.mercadolivre.produto.Produto;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

@Entity
public class Compra {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne
	private Produto produtoComprado;
	
	@Positive
	private int quantidade;
	
	@NotNull
	@ManyToOne
	private Usuario comprador;
	
	@NotNull
	@Enumerated
	private GatewayPagamento gateway;

	public Compra(Produto produtoComprado, int quantidade, Usuario comprador, GatewayPagamento gateway) {
		this.produtoComprado = produtoComprado;
		this.quantidade = quantidade;
		this.comprador = comprador;
		this.gateway = gateway;
	}

	
	public Long getId() {
		return id;
	}

	public Produto getProdutoComprado() {
		return produtoComprado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Usuario getComprador() {
		return comprador;
	}
	
	public GatewayPagamento getGateway() {
		return gateway;
	}


	@Override
	public String toString() {
		return "Compra [id=" + id + ", produtoComprado=" + produtoComprado + ", quantidade=" + quantidade
				+ ", comprador=" + comprador + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (gateway != other.gateway)
			return false;
		return true;
	}
	
	
	
	

}

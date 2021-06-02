package br.com.mercadozup.mercadolivre.finalizarcompra;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.mercadozup.mercadolivre.produto.Produto;
import br.com.mercadozup.mercadolivre.usuario.Usuario;
import io.jsonwebtoken.lang.Assert;

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
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
	private Set<Transacao> transacoes = new HashSet<>();
	
	
	
	@Deprecated
	public Compra() {

	}


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
				+ ", comprador=" + comprador + ", gateway=" + gateway + ", transacoes=" + transacoes + "]";
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


	public void adicionaTransacao(@Valid RetornoGatewayPagamento retornoGatewayPagamento) {
		
		Transacao novaTransacao = retornoGatewayPagamento.toTransacao(this);
		
		Assert.isTrue(!this.transacoes.contains(novaTransacao), "Essa transação já foi processada "+novaTransacao.toString());
		Set<Transacao> transacoesConcluidasComSucesso = transacoesConcluidasComSucesso();
		
		Assert.isTrue(transacoesConcluidasComSucesso.isEmpty(), "Essa compra já foi concluida!");
		
		this.transacoes.add(retornoGatewayPagamento.toTransacao(this));
		
	}

	
	
	private Set<Transacao> transacoesConcluidasComSucesso() {
		Set<Transacao> transacoesConcluidasComSucesso = this.transacoes.stream().filter(Transacao :: concluidaComSucesso).collect(Collectors.toSet());
		Assert.isTrue(transacoesConcluidasComSucesso.size() <= 1, "Mais de uma transação foi concluida com sucesso!");
		return transacoesConcluidasComSucesso;
	}
	
	
	public boolean processadaComSucesso() {
		return !transacoesConcluidasComSucesso().isEmpty();
	}
	
	
	

}

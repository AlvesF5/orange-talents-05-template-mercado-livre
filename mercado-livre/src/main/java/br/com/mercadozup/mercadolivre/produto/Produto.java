package br.com.mercadozup.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.mercadozup.mercadolivre.categoria.Categoria;

@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private BigDecimal valor;
	
	private Integer quantidade;
	
	@OneToMany(mappedBy="produto", cascade = CascadeType.ALL)
	private List<Caracteristica> caracteristicas;
	
	private String descricao;
	
	@ManyToOne
	private Categoria categoria;
	
	private LocalDateTime instanceCriacao = LocalDateTime.now();
	
	
	@Deprecated
	public Produto() {
	}



	public Produto(String nome, BigDecimal valor, Integer quantidade, List<Caracteristica> caracteristicas, String descricao,
			Categoria categoria) {
	
		        caracteristicas.forEach(
		        		caracteristica -> {
		        			caracteristica.setProduto(this);
				});
		
		
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.caracteristicas = caracteristicas;
		this.descricao = descricao;
		this.categoria = categoria;
	}



	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

	public BigDecimal getValor() {
		return valor;
	}


	public Integer getQuantidade() {
		return quantidade;
	}
	
	
	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}


	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public LocalDateTime getInstanceCriacao() {
		return instanceCriacao;
	}



	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	

	
	
	
}

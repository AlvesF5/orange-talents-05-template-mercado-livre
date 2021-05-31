package br.com.mercadozup.mercadolivre.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import br.com.mercadozup.mercadolivre.categoria.Categoria;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

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

	@ManyToOne @JoinColumn(name ="donoProduto")
	private Usuario donoProduto;

	@OneToMany(mappedBy="produto", cascade = CascadeType.ALL)
	
	private Set<ImagemProduto> imagens = new HashSet<>();
	
	private LocalDateTime instanceCriacao = LocalDateTime.now();
	
	
	@Deprecated
	public Produto() {
	}



	public Produto(String nome, BigDecimal valor, Integer quantidade, List<Caracteristica> caracteristicas, String descricao,
			Categoria categoria, Usuario donoProduto) {
	
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
		this.donoProduto = donoProduto;
	}
	
	
	public void adicionarImagens(Set<String> links) {
		Set<ImagemProduto> imagens = links.stream().map(link -> new ImagemProduto(this,  link) ).collect(Collectors.toSet());
		this.imagens.addAll(imagens);
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
	
	public Usuario getDonoProduto() {
		return donoProduto;
	}

	public LocalDateTime getInstanceCriacao() {
		return instanceCriacao;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	
	public Long getIdDonoProduto() {
		return donoProduto.getId();
	}

	public Set<ImagemProduto> getImagens() {
		return imagens;
	}

	
	
	
	
}

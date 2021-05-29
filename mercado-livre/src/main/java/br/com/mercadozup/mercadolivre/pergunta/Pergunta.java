package br.com.mercadozup.mercadolivre.pergunta;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.mercadozup.mercadolivre.produto.Produto;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

@Entity
public class Pergunta {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	@ManyToOne
	private Usuario donoPergunta;
	@ManyToOne
	private Produto produto;
	private LocalDateTime criadaEm = LocalDateTime.now();
	
	
	
	
	@Deprecated
	public Pergunta() {
	}


	public Pergunta(String titulo, String descricao, Usuario donoPergunta, Produto produto) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.donoPergunta = donoPergunta;
		this.produto = produto;
	}


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Usuario getDonoPergunta() {
		return donoPergunta;
	}

	public Produto getProduto() {
		return produto;
	}

	public LocalDateTime getCriadaEm() {
		return criadaEm;
	}
	
	
	
	
	

}

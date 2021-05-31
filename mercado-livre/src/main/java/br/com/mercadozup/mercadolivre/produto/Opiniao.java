package br.com.mercadozup.mercadolivre.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.mercadozup.mercadolivre.usuario.Usuario;

@Entity
public class Opiniao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer nota;
	private String titulo;
	private String descricao;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Usuario donoOpiniao;
	
	
	@Deprecated
	public Opiniao() {
	}


	public Opiniao(Integer nota, String titulo, String descricao, Produto produto, Usuario donoOpiniao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.produto = produto;
		this.donoOpiniao = donoOpiniao;
	}


	public Integer getNota() {
		return nota;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public Produto getProduto() {
		return produto;
	}


	public Usuario getDonoOpiniao() {
		return donoOpiniao;
	}

	
	
	
}

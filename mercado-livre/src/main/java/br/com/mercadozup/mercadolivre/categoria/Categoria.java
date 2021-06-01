package br.com.mercadozup.mercadolivre.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne(optional = true)
	private Categoria categoriaMae;
	

	public Categoria() {
	}


	public Categoria(String nome, Categoria categoriaMae) {
		this.nome = nome;
		this.categoriaMae = categoriaMae;
	}


	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}


	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", categoriaMae=" + categoriaMae + "]";
	}
	
	
	
	
	
	
	
}

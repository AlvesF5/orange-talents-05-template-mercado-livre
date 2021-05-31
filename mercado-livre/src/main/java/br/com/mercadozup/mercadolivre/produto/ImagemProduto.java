package br.com.mercadozup.mercadolivre.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class ImagemProduto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @NotNull
	private Produto produto;
	@Size(min=45)
	private String link;

	
	
	public ImagemProduto() {
	}

	public ImagemProduto(Produto produto, String link) {
		this.produto = produto;
		this.link = link;
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public String getLink() {
		return link ;
	}

	public void setLink(String link) {
		this.link = link;
	}

	

}

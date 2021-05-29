package br.com.mercadozup.mercadolivre.produto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



import br.com.mercadozup.mercadolivre.categoria.ExisteId;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

public class OpiniaoRequestDTO {
	
	@Min(1) @Max(5) @NotNull
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank @Length(max=500)
	private String descricao;
	@NotNull
	@ExisteId(domainClass = Produto.class, fieldName = "id")
	private Long idProduto;
	
	
	
	
	public Opiniao transformarParaOpiniao(EntityManager manager, Usuario donoOpiniao) {
		
		Produto produto = manager.find(Produto.class, idProduto);
			
		return new Opiniao(nota,titulo,descricao,produto,donoOpiniao);
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
	public Long getIdProduto() {
		return idProduto;
	}



	
	
	
	
	
	
	
	
	
	
	
	
}

package br.com.mercadozup.mercadolivre.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;


import br.com.mercadozup.mercadolivre.usuario.UniqueValue;

public class CategoriaRequestDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	@ExisteId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoriaMae;
	
	
	public Categoria transformarParaObjeto(EntityManager manager) {
		
		Categoria categoriaMae = null;
		
		if(idCategoriaMae!=null) {
			categoriaMae = manager.find(Categoria.class, idCategoriaMae);
		}
		
		return new Categoria(nome,categoriaMae);
	}


	public String getNome() {
		return nome;
	}


	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}
	
	
	
}

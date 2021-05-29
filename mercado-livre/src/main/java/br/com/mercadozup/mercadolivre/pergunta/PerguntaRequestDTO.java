package br.com.mercadozup.mercadolivre.pergunta;



import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.mercadozup.mercadolivre.categoria.ExisteId;
import br.com.mercadozup.mercadolivre.produto.Produto;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

public class PerguntaRequestDTO {
	
	@NotEmpty
	private String titulo;
	@NotEmpty
	private String descricao;
	@NotNull
	@ExisteId(domainClass = Produto.class, fieldName = "id")
	private Long idProduto;
	
	
	
	public Pergunta transformarParaPergunta(EntityManager manager, Usuario donoPergunta) {
		
		Produto produto = manager.find(Produto.class, idProduto);
		return new Pergunta(titulo,descricao,donoPergunta,produto);
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

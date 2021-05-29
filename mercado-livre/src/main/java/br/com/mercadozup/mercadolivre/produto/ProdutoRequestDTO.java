package br.com.mercadozup.mercadolivre.produto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.mercadozup.mercadolivre.categoria.Categoria;
import br.com.mercadozup.mercadolivre.categoria.ExisteId;
import br.com.mercadozup.mercadolivre.usuario.Usuario;




public class ProdutoRequestDTO {
	
	@NotBlank
	private String nome;
	
	@NotNull @Min(0)
	private BigDecimal valor;
	
	@NotNull @Min(0)
	private Integer quantidade;
	
	
	@Size(min=3) @NotEmpty
	private List<Caracteristica> caracteristicas;
	
	@NotBlank @Size(max=1000)
	private String descricao;
	
	@ExisteId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	
	
	
	public Produto transformarParaProduto(EntityManager manager, Usuario donoProduto) {
		Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		return new Produto(nome,valor,quantidade,caracteristicas,descricao,categoria,donoProduto);
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


	public Long getIdCategoria() {
		return idCategoria;
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

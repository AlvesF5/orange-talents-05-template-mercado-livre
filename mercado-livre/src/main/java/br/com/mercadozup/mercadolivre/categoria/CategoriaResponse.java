package br.com.mercadozup.mercadolivre.categoria;



public class CategoriaResponse {
	
	private String nome;
	
	private Categoria categoriaMae;
	
	
	public CategoriaResponse(Categoria categoria) {
		this.nome=categoria.getNome();
		this.categoriaMae=categoria.getCategoriaMae();
	}


	
	public String getNome() {
		return nome;
	}

	public Categoria getCategoriaMae() {
		return categoriaMae;
	}
	
	
	
}

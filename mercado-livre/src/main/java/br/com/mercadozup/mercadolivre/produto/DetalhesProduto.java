package br.com.mercadozup.mercadolivre.produto;

import java.math.BigDecimal;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;



import br.com.mercadozup.mercadolivre.categoria.CategoriaResponse;

import br.com.mercadozup.mercadolivre.pergunta.PerguntaRepository;
import br.com.mercadozup.mercadolivre.pergunta.PerguntaResponse;


public class DetalhesProduto {
	
	@Autowired
	private OpiniaoRespository opiniaoRespository;
	@Autowired
	private PerguntaRepository perguntaRepository;
	@Autowired
	private ImagemProdutoRepository imagemProdutoRepository;
	
	private List<ImagemProdutoResponse> imagens;
	
	private String nome;
	
	private BigDecimal valor;
	
	private Integer quantidade;
	
	private List<Caracteristica> caracteristicas;
	
	private String descricao;
	
	private CategoriaResponse categoriaResponse;
	
	private List<OpiniaoResponse> opinioes;
	
	private List<PerguntaResponse> perguntas;
	
	private Integer qtdOpinioes;
	
	private Double notaMediaOpinioes;
	
	
	public DetalhesProduto(Produto produto, OpiniaoRespository opiniaoRespositor, ImagemProdutoRepository imagemProdutoRepository, PerguntaRepository perguntaRepository ) {
		this.perguntaRepository=perguntaRepository;
		this.opiniaoRespository=opiniaoRespositor;
		this.imagemProdutoRepository=imagemProdutoRepository;
		this.imagens=linkImagensProdutos(produto);
		this.nome=produto.getNome();
		this.valor=produto.getValor();
		this.quantidade=produto.getQuantidade();
		this.caracteristicas=produto.getCaracteristicas();
		this.descricao=produto.getDescricao();
		this.categoriaResponse= new CategoriaResponse(produto.getCategoria());
		this.opinioes=opinioesProduto(produto);
		this.perguntas=perguntasProduto(produto);
		this.qtdOpinioes=opinioesProduto(produto).size();
		this.notaMediaOpinioes =  calculaMediaAvaliacoes();
	}
	
	
	public List<OpiniaoResponse> opinioesProduto(Produto produto){
		return OpiniaoResponse.converter(opiniaoRespository.findByProdutoId(produto.getId()));
	}
	
	public List<PerguntaResponse> perguntasProduto(Produto produto){
		return PerguntaResponse.converter(perguntaRepository.findByProdutoId(produto.getId())) ;
	}
	
	public List<ImagemProdutoResponse> linkImagensProdutos(Produto produto){	
		return ImagemProdutoResponse.converter(imagemProdutoRepository.findByProdutoId(produto.getId()));
	}



	public List<ImagemProdutoResponse> getImagens() {
		return imagens;
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


	public List<CaracteristicaResponse> getCaracteristicas() {
		
		return CaracteristicaResponse.converter(caracteristicas);
	}


	public String getDescricao() {
		return descricao;
	}



	public CategoriaResponse getCategoriaResponse() {
		return categoriaResponse;
	}


	public List<OpiniaoResponse> getOpinioes() {
		return opinioes;
	}



	public List<PerguntaResponse> getPerguntas() {
		return perguntas;
	}


	

	public Integer getQtdOpinioes() {
		return qtdOpinioes;
	}


	
	public Double getNotaMediaOpinioes() {
		return notaMediaOpinioes;
	}


	public  double calculaMediaAvaliacoes() {
	      
	   var optionalAverage = opinioes.stream().mapToDouble(OpiniaoResponse::getNota).average();

	   return optionalAverage.orElse(0.0);
	}
	
	
	

}

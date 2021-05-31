package br.com.mercadozup.mercadolivre.produto;

import java.util.List;
import java.util.stream.Collectors;

public class ImagemProdutoResponse {
	
	private String link;
	
	
	public ImagemProdutoResponse(ImagemProduto imagemProduto) {
		this.link=imagemProduto.getLink();
	}
	
	
	public static List<ImagemProdutoResponse> converter(List<ImagemProduto> imagens){
		
		return imagens.stream().map(ImagemProdutoResponse::new).collect(Collectors.toList());
		
	}


	public String getLink() {
		return link;
	}
	
	
	
}

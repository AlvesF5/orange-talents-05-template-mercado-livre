package br.com.mercadozup.mercadolivre.produto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NovasImagensRequest {
	
	@Size(min = 1) 	@NotEmpty
	List<MultipartFile> imagens = new ArrayList<>();
	
	
	
	public List<MultipartFile> getImagens(){
		return imagens;
	}
	

	public NovasImagensRequest(List<MultipartFile> imagens) {
		this.imagens = imagens;
	}
	


}

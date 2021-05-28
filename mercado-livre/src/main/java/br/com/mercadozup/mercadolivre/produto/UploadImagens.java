package br.com.mercadozup.mercadolivre.produto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;





@Component
public class UploadImagens {
	
	public static Set<String> enviar(@NotNull List<MultipartFile> imagens){
		
		return imagens.stream().map(imagem ->  imagem.getOriginalFilename()).collect(Collectors.toSet());
		
		
	}
	
	
	
}

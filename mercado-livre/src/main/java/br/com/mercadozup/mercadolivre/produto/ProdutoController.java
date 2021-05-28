package br.com.mercadozup.mercadolivre.produto;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadozup.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> novoProduto(@AuthenticationPrincipal Usuario donoProduto, @RequestBody @Valid ProdutoRequestDTO produtoDTO){
		Produto produto = produtoDTO.transformarParaProduto(manager, donoProduto);
		produtoRepository.save(produto);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/imagens/{id}")
	public ResponseEntity<?> adicionaImagensProduto(@PathVariable("id") Long id,  @Valid NovasImagensRequest request, @AuthenticationPrincipal Usuario donoProduto) {
		Set<String>   links = UploadImagens.enviar(request.getImagens());
		System.out.println("Links das imagens: "+links);
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.get().getIdDonoProduto()==donoProduto.getId()) {
			produto.get().adicionarImagens(links);
			produtoRepository.save(produto.get());
			return ResponseEntity.ok().build();
		}else return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		
		
		
	}

}

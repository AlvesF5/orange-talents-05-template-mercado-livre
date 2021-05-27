package br.com.mercadozup.mercadolivre.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> novoProduto(@RequestBody @Valid ProdutoRequestDTO produtoDTO){
		Produto produto = produtoDTO.transformarParaProduto(manager);
		produtoRepository.save(produto);
		return ResponseEntity.ok().build();
	}

}

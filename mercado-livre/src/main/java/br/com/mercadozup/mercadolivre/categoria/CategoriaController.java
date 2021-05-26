package br.com.mercadozup.mercadolivre.categoria;

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
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	public ResponseEntity<?> novaCategoria(@RequestBody @Valid CategoriaRequestDTO categoriaDTO){
		Categoria categoria = categoriaDTO.transformarParaObjeto(manager);
		categoriaRepository.save(categoria);		
		return ResponseEntity.ok().build();
	}

}

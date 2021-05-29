package br.com.mercadozup.mercadolivre.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadozup.mercadolivre.usuario.Usuario;



@RestController
@RequestMapping("/opinioes")
public class OpiniaoController {
	
	
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	OpiniaoRespository opiniaoRespository;
	
	@PostMapping
	public ResponseEntity<?> novaOpiniao(@RequestBody @Valid OpiniaoRequestDTO opiniaoDTO, @AuthenticationPrincipal Usuario donoOpiniao){
		Opiniao opiniao = opiniaoDTO.transformarParaOpiniao(manager, donoOpiniao);
		opiniaoRespository.save(opiniao);
		return ResponseEntity.ok().build();
	}

}

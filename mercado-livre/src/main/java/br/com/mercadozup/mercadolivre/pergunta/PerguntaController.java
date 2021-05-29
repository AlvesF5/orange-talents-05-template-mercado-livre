package br.com.mercadozup.mercadolivre.pergunta;

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

import br.com.mercadozup.mercadolivre.email.DisparadorDeEmail;
import br.com.mercadozup.mercadolivre.usuario.Usuario;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private DisparadorDeEmail disparadorDeEmail;
	
	@PostMapping
	public ResponseEntity<?> novaPergunta(@RequestBody @Valid PerguntaRequestDTO perguntaDTO, @AuthenticationPrincipal Usuario donoPergunta){
		Pergunta pergunta = perguntaDTO.transformarParaPergunta(manager, donoPergunta);
		perguntaRepository.save(pergunta);	
		
		
		disparadorDeEmail.dispararEmail(pergunta);
		
		return ResponseEntity.ok().build();
	}

}

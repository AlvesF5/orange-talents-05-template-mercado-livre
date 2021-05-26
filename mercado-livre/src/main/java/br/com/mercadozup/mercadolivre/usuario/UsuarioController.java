package br.com.mercadozup.mercadolivre.usuario;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<?> novoUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Usuario usuario = usuarioDTO.transformarParaUsuario();
		
		usuarioRepository.save(usuario);
		
		return ResponseEntity.ok().build();
	}

}

package br.com.mercadozup.mercadolivre.security;

import javax.naming.AuthenticationException;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadozup.mercadolivre.usuario.LoginFormDTO;


@RestController
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private GerenciadorDeToken gerenciadorDeToken;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginFormDTO loginForm){
		
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
		
		try {
			Authentication authentication =   authManager.authenticate(dadosLogin);
			String token = gerenciadorDeToken.gerarToken(authentication);
			System.out.println("token:" +token);		
			return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		
	}

}

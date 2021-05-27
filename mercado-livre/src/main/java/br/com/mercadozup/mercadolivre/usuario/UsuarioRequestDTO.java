package br.com.mercadozup.mercadolivre.usuario;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



public class UsuarioRequestDTO {
	
	@Email @NotBlank @NotNull 
	@UniqueValue(domainClass = Usuario.class, fieldName = "login")
	private String login;
	@NotBlank @NotNull @Length(min=6)
	private String senha;
	
	
	public Usuario transformarParaUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCrip = encoder.encode(senha);
		
		return new Usuario(login,senhaCrip);
	}



	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}


	
	
	
	
}
